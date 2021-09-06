package org.salvador.caetano.financiamentoviatura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrestacaoService {

	@Autowired
	TipoFinanciamentoService tipoFinanciamentoService;
	
	public Double calcular(Double valorViatura, Long meses, String tipoFinanciamento) {
		return (valorViatura + (valorViatura * tipoFinanciamentoService.getFator(tipoFinanciamento) / 100)) / meses;
	}
}
