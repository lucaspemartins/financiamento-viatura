package org.salvador.caetano.financiamentoviatura.model;

import lombok.Getter;

@Getter
public enum TipoFinanciamentoEnum {
	INTERNO("Interno"),
	EXTERNO("Externo");
	
	private String tipoFinanciamento;
	
	TipoFinanciamentoEnum(String tipoFinanciamento) {
		this.tipoFinanciamento = tipoFinanciamento;
	}
}
