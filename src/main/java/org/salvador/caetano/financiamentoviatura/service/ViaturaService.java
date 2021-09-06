package org.salvador.caetano.financiamentoviatura.service;

import java.util.List;

import org.salvador.caetano.financiamentoviatura.model.Viatura;
import org.salvador.caetano.financiamentoviatura.repository.ViaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViaturaService {
	
	@Autowired
	ViaturaRepository viaturaRepository;
	
	public List<Viatura> findAll() {
		return viaturaRepository.findAll();
	}

}
