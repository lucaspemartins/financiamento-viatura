package org.salvador.caetano.financiamentoviatura.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class RelatorioRequest {
	
	@NotBlank
	private String nome;
	@NotBlank
	private String contacto;
	@NotBlank
	private String tipoFinanciamento;
	@NotNull
	private Long meses;
	@NotBlank
	private String nomeViatura;
	@NotNull
	private Double valorViatura;
	private Double fator;
	@NotNull
	private Double prestacao;

}
