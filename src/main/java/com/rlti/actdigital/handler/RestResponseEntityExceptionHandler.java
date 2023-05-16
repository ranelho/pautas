package com.rlti.actdigital.handler;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestControllerAdvice
@Log4j2
public class RestResponseEntityExceptionHandler {
	@ExceptionHandler(APIException.class)
	public ResponseEntity<ErrorApiResponse> handlerGenericException(APIException ex) {
		return ex.buildErrorResponseEntity();
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorApiResponse> handlerGenericException(Exception ex) {
		log.error("Exception: ", ex);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ErrorApiResponse.builder().description("INTERNAL SERVER ERROR!")
						.message("POR FAVOR INFORME AO ADMINISTRADOR DO SISTEMA!").build());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String, String> handleConstraintViolationException(ConstraintViolationException ex) {
		Map<String, String> errors = new HashMap<>();
		Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
		constraintViolations.forEach((violation) -> {
			String propertyName = violation.getPropertyPath().toString();
			String errorMessage = violation.getMessage();
			errors.put(propertyName, errorMessage);
		});
		return errors;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Map<String, String>> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
		Throwable rootCause = ex.getRootCause();
		if (rootCause instanceof DateTimeParseException) {
			DateTimeParseException dateTimeParseException = (DateTimeParseException) rootCause;
			return handleDateTimeParseException(dateTimeParseException);
		}
		Map<String, String> errors = new HashMap<>();
		errors.put("message", "Erro de desserialização do JSON");
		return ResponseEntity.badRequest().body(errors);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(DateTimeParseException.class)
	public ResponseEntity<Map<String, String>> handleDateTimeParseException(DateTimeParseException ex) {
		Map<String, String> errors = new HashMap<>();
		errors.put("message", "Formato de data inválido: formato padrão -> 'yyyy-MM-dd'T'HH:mm:ss'");
		return ResponseEntity.badRequest().body(errors);
	}
}
