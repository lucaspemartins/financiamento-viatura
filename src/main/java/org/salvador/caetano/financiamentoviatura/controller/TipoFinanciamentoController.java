package org.salvador.caetano.financiamentoviatura.controller;

import java.util.List;

import org.salvador.caetano.financiamentoviatura.model.Mensalidade;
import org.salvador.caetano.financiamentoviatura.model.TipoFinanciamento;
import org.salvador.caetano.financiamentoviatura.service.TipoFinanciamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TipoFinanciamentoController {
	
	@Autowired
	TipoFinanciamentoService tipoFinanciamentoService;
	
	@GetMapping("/tipo-financiamento")
	public ResponseEntity<Object> findAll() {
		List<TipoFinanciamento> tipoFinanciamentoList = tipoFinanciamentoService.findAll();
		HttpStatus responseStatus = HttpStatus.OK;
		if (tipoFinanciamentoList.isEmpty()) {
			responseStatus = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(tipoFinanciamentoService.findAll(), responseStatus);
	}
	
	@GetMapping("/tipo-financiamento/{idTipoFinanciamento}/mensalidade")
	public ResponseEntity<Object> findAll(@PathVariable Long idTipoFinanciamento) {
		List<Mensalidade> mensalidadeList = tipoFinanciamentoService.findAllByTipoFinanciamento(idTipoFinanciamento);
		HttpStatus responseStatus = HttpStatus.OK;
		if (mensalidadeList.isEmpty()) {
			responseStatus = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(mensalidadeList, responseStatus);
	}

}
