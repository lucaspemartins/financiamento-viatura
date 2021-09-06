package org.salvador.caetano.financiamentoviatura.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Mensalidade {
	@Id
	private Long id;
	private Long meses;
	
	@JsonIgnore
	@ManyToMany
	List<TipoFinanciamento> tipoFinanciamento;
}
