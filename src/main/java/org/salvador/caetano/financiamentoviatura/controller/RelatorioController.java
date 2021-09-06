package org.salvador.caetano.financiamentoviatura.controller;

import javax.validation.Valid;

import org.salvador.caetano.financiamentoviatura.model.ApiExceptionModel;
import org.salvador.caetano.financiamentoviatura.model.RelatorioRequest;
import org.salvador.caetano.financiamentoviatura.service.RelatorioService;
import org.salvador.caetano.financiamentoviatura.service.TipoFinanciamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RelatorioController {
	
	@Autowired
	RelatorioService relatorioService;
	
	@Autowired
	TipoFinanciamentoService tipoFinanciamentoService;
	
	@PostMapping("/relatorio")
	public ResponseEntity<Object> gerar(@RequestBody @Valid RelatorioRequest relatorioParametros) {
		Double fator = tipoFinanciamentoService.getFator(relatorioParametros.getTipoFinanciamento());
		relatorioParametros.setFator(fator);
		HttpStatus responseStatus = HttpStatus.OK;
		try {
			relatorioService.gerar(relatorioParametros);
		} catch (Exception e) {
			responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			return new ResponseEntity<>(new ApiExceptionModel(e.getMessage(), responseStatus.value()), responseStatus);
		}
		return new ResponseEntity<>(responseStatus);
	}
}
