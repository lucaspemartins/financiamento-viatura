package org.salvador.caetano.financiamentoviatura.model;

import lombok.Data;

@Data
public class ApiExceptionModel {
	private String message;
	private int status;
	
	public ApiExceptionModel(String message, int status) {
		this.message = message;
		this.status = status;
	}
	
}
