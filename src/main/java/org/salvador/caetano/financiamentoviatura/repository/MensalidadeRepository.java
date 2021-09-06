package org.salvador.caetano.financiamentoviatura.repository;

import java.util.List;

import org.salvador.caetano.financiamentoviatura.model.Mensalidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MensalidadeRepository extends JpaRepository<Mensalidade, Long> {

	@Query("SELECT m FROM Mensalidade m "
			+ "JOIN m.tipoFinanciamento mtf "
			+ "WHERE mtf.id = :tipo_financiamento_id")
	List<Mensalidade> findAllByTipoFinanciamento(@Param("tipo_financiamento_id") Long idTipoFinanciamento);
}
