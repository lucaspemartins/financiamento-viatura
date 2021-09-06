package org.salvador.caetano.financiamentoviatura.service;

import org.salvador.caetano.financiamentoviatura.model.RelatorioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RelatorioService {
	
	@Autowired
	JasperCompilerService jasperCompilerService;
	
	@Value("${financiamento.report.template.path}")
	private String financiamentoReportTemplatePath;
	
	@Value("${financiamento.report.template.name}")
	private String financiamentoReportTemplateName;
	
	public void gerar(RelatorioRequest relatorioParametros) {
		jasperCompilerService.gerar(relatorioParametros, financiamentoReportTemplatePath, financiamentoReportTemplateName);
	}
}
