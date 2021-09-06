package org.salvador.caetano.financiamentoviatura.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PrestacaoRequest {
	@NotNull
	private Double valorViatura;
	@NotNull
	private Long meses;
	@NotBlank
	private String tipoFinanciamento;
}
