package org.salvador.caetano.financiamentoviatura.exception.model;

public class RelatorioException extends RuntimeException {
	private static final long serialVersionUID = 4042206098002427321L;
	public RelatorioException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
