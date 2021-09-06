package org.salvador.caetano.financiamentoviatura.controller;

import java.util.List;

import org.salvador.caetano.financiamentoviatura.model.Viatura;
import org.salvador.caetano.financiamentoviatura.service.ViaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViaturaController {
	
	@Autowired
	ViaturaService viaturaService;
	
	@GetMapping("/viatura")
	public ResponseEntity<Object> findAll() {
		List<Viatura> viaturaList = viaturaService.findAll();
		HttpStatus responseStatus = HttpStatus.OK;
		if (viaturaList.isEmpty()) {
			responseStatus = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(viaturaService.findAll(), responseStatus);
	}

}
