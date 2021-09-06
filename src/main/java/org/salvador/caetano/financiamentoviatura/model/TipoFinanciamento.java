package org.salvador.caetano.financiamentoviatura.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class TipoFinanciamento {
	@Id
	private Long id;
	private String tipo;
}
