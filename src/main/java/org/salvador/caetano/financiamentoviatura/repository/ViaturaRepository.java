package org.salvador.caetano.financiamentoviatura.repository;

import java.util.List;

import org.salvador.caetano.financiamentoviatura.model.Viatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViaturaRepository extends JpaRepository<Viatura, Long> {
	
	List<Viatura> findAll();

}
