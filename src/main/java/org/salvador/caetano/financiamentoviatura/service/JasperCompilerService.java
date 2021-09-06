package org.salvador.caetano.financiamentoviatura.service;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.jboss.logging.Logger;
import org.salvador.caetano.financiamentoviatura.exception.model.RelatorioException;
import org.salvador.caetano.financiamentoviatura.model.RelatorioRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;

@Service
public class JasperCompilerService {
	private static final Logger LOG = Logger.getLogger(JasperCompilerService.class);
	private static final String PDF_FILE_EXTESION = ".pdf";
	
	@Value("${financiamento.report.output.path}")
	private String financiamentoReportOutputPath;

	public JasperReport compileReport(String reportTemplatePath, String reportTemplateName) throws JRException {
		String reportTemplate = reportTemplatePath + reportTemplateName;
		InputStream financiamentoReportStream = getClass().getResourceAsStream(reportTemplate);
		return JasperCompileManager.compileReport(financiamentoReportStream);
	}

	public JasperPrint fillReport(JasperReport jasperReport, Object relatorioParametros)
			throws IllegalArgumentException, IllegalAccessException, JRException {
		Map<String, Object> parameters = mapParameters(relatorioParametros);
		return JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
	}

	private Map<String, Object> mapParameters(Object relatorioParametros)
			throws IllegalArgumentException, IllegalAccessException {
		Map<String, Object> parameters = new HashMap<>();
		Field[] fields = relatorioParametros.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			Object value = field.get(relatorioParametros);
			parameters.put(field.getName(), value);
			field.setAccessible(false);
		}
		return parameters;
	}

	private void exportPdf(JasperPrint jasperPrint) throws JRException {
		JRPdfExporter exporter = new JRPdfExporter();
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		String reportName = generateReportName(financiamentoReportOutputPath, PDF_FILE_EXTESION);
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(reportName));

		SimplePdfReportConfiguration reportConfig = new SimplePdfReportConfiguration();
		reportConfig.setSizePageToContent(true);
		reportConfig.setForceLineBreakPolicy(false);

		SimplePdfExporterConfiguration exportConfig = new SimplePdfExporterConfiguration();
		exportConfig.setMetadataAuthor("salvadorCaetano");
		exportConfig.setAllowedPermissionsHint("PRINTING");

		exporter.setConfiguration(reportConfig);
		exporter.setConfiguration(exportConfig);
		exporter.exportReport();

	}

	private String generateReportName(String outputPath, String fileExtension) {
		String reportPrefixName = "financiamentoReport";
		long currentTime = System.currentTimeMillis();
		return outputPath + reportPrefixName + currentTime + fileExtension;
	}

	public void gerar(RelatorioRequest relatorioParametros, String reportTemplatePath, String reportTemplateName) {
		try {
			JasperReport jasperReport = compileReport(reportTemplatePath, reportTemplateName);
			JasperPrint jasperPrint = fillReport(jasperReport, relatorioParametros);
			exportPdf(jasperPrint);
		} catch (IllegalArgumentException | IllegalAccessException | JRException e) {
			LOG.error(e.getMessage());
			throw new RelatorioException(e.getMessage(), e);
		}
	}
}
