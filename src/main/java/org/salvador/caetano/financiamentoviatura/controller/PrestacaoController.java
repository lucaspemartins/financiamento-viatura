package org.salvador.caetano.financiamentoviatura.controller;

import javax.validation.Valid;

import org.salvador.caetano.financiamentoviatura.model.Prestacao;
import org.salvador.caetano.financiamentoviatura.model.PrestacaoRequest;
import org.salvador.caetano.financiamentoviatura.service.PrestacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class PrestacaoController {
	
	@Autowired
	PrestacaoService prestacaoService;
	
	@GetMapping("/prestacao")
	public ResponseEntity<Object> calcularPrestacao(@ModelAttribute @Valid PrestacaoRequest prestacaoParametros) {
		Double valorPrestacao = prestacaoService.calcular(prestacaoParametros.getValorViatura(), prestacaoParametros.getMeses(), prestacaoParametros.getTipoFinanciamento());
		Prestacao prestacao = new Prestacao();
		prestacao.setValor(valorPrestacao);
		return new ResponseEntity<>(prestacao, HttpStatus.OK);
	}
}
