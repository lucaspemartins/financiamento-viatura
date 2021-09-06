package org.salvador.caetano.financiamentoviatura.service;

import java.util.List;

import org.salvador.caetano.financiamentoviatura.model.FatorFinanciamento;
import org.salvador.caetano.financiamentoviatura.model.Mensalidade;
import org.salvador.caetano.financiamentoviatura.model.TipoFinanciamento;
import org.salvador.caetano.financiamentoviatura.model.TipoFinanciamentoEnum;
import org.salvador.caetano.financiamentoviatura.repository.MensalidadeRepository;
import org.salvador.caetano.financiamentoviatura.repository.TipoFinanciamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoFinanciamentoService {
	
	@Autowired
	TipoFinanciamentoRepository tipoFinanciamentoRepository;
	
	@Autowired
	MensalidadeRepository mensalidadeRepository;
	
	@Autowired
	FatorFinanciamento fatorFinanciamento;
	
	public List<TipoFinanciamento> findAll() {
		return tipoFinanciamentoRepository.findAll();
	}
	
	public List<Mensalidade> findAllByTipoFinanciamento(Long idTipoFinanciamento) {
		return mensalidadeRepository.findAllByTipoFinanciamento(idTipoFinanciamento);
	}
	
	public Double getFator(String tipoFinanciamento) {
		Double fator = null;
		if (tipoFinanciamento.equals(TipoFinanciamentoEnum.INTERNO.getTipoFinanciamento())) {
			fator = fatorFinanciamento.getFatorFinanciamentoInterno();
		} else if (tipoFinanciamento.equals(TipoFinanciamentoEnum.EXTERNO.getTipoFinanciamento())) {
			fator = fatorFinanciamento.getFatorFinanciamentoExterno();
		}
		return fator;
	}

}
