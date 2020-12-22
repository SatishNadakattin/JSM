package com.app.exception;



import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_INTERNAL_SERVER_ERROR;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@SuppressWarnings("rawtypes")
@ControllerAdvice
public class BankExceptionHandler {

	@Autowired
	
	public HttpResponseUtils HttpResponseUtils;
	
	
	public BankExceptionHandler() {
		super();
	}

	@ExceptionHandler(BankRestException.class)
	@ResponseBody
	private ResponseEntity<GenericRes> handleApplicationException(BankRestException ex, HttpServletRequest request,
			HttpServletResponse response) {
		return HttpResponseUtils.prepareErrorResponse(ex);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseBody
	private ResponseEntity<GenericRes> handleBadRequestsErrors(HttpMessageNotReadableException ex,
			HttpServletRequest request, HttpServletResponse response) {
		return HttpResponseUtils.prepareErrorResponse(ex, SC_BAD_REQUEST);
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
		@ResponseBody
		private ResponseEntity<GenericRes> handleMissingServletRequestParameterException(
				MissingServletRequestParameterException ex, HttpServletRequest request, HttpServletResponse response) {
			return HttpResponseUtils.prepareErrorResponse(ex, SC_BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	private ResponseEntity<GenericRes> handleMethodArgException(MethodArgumentNotValidException ex,
			HttpServletRequest request, HttpServletResponse response) {
		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();
		String message = "Validation failed for following argument(s):: {";
		if (fieldErrors != null && fieldErrors.size() > 0) {
			for (FieldError fieldError : fieldErrors) {
				message += fieldError.getField() + " : " + fieldError.getDefaultMessage() + ",";
			}
			message = message.substring(0, message.length() - 1) + " }";
		}
		return HttpResponseUtils.prepareErrorResponse(ex, SC_BAD_REQUEST, message);
	}

	@ExceptionHandler(Throwable.class)
	@ResponseBody
	private ResponseEntity<GenericRes> handleException(Throwable ex, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return HttpResponseUtils.prepareErrorResponse(ex, SC_INTERNAL_SERVER_ERROR);
	}

}