package org.salvador.caetano.financiamentoviatura.repository;

import java.util.List;

import org.salvador.caetano.financiamentoviatura.model.TipoFinanciamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoFinanciamentoRepository extends JpaRepository<TipoFinanciamento, Long> {
	
	List<TipoFinanciamento> findAll();
}
