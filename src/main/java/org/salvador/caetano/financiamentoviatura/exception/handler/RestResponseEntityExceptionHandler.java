package org.salvador.caetano.financiamentoviatura.exception.handler;

import java.util.List;
import java.util.stream.Collectors;

import org.salvador.caetano.financiamentoviatura.model.ApiExceptionModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ApiExceptionModel apiExceptionModel = new ApiExceptionModel(ex.getMessage(), status.value());
		return new ResponseEntity<>(apiExceptionModel, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());
		ApiExceptionModel apiExceptionModel = new ApiExceptionModel(errors.toString(), status.value());
		return new ResponseEntity<>(apiExceptionModel, HttpStatus.BAD_REQUEST);
	}
}
