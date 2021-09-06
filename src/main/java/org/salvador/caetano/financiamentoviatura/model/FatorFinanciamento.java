package org.salvador.caetano.financiamentoviatura.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class FatorFinanciamento {
	
	@Value("${fator.financiamento.interno}")
	private Double fatorFinanciamentoInterno;
	@Value("${fator.financiamento.externo}")
	private Double fatorFinanciamentoExterno;

}
