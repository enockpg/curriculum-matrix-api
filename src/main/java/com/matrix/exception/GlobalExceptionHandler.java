package com.matrix.exception;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;


/**
 * Class to handle exceptions
 * 
 * @author enockpinheiro
 * @since 
 */

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@Autowired
	private MessageSource msgSource;
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErroMessage exception(Exception ex) {
		String erro = msgSource.getMessage("msg-error.constraint-violation", null, LocaleContextHolder.getLocale());
		String cause = ex.getCause() != null ? ex.getCause().toString() : ex.toString();
		ErroMessage msg = new ErroMessage(erro, cause);
		log.error(msg.toString());
		return msg;
	}
	
	@ExceptionHandler(value = { EmptyResultDataAccessException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErroMessage emptyResultDataAccess(EmptyResultDataAccessException ex) {
		String erro = msgSource.getMessage("msg-error.empty-result", null, LocaleContextHolder.getLocale());
		String cause = ex.getCause() != null ? ex.getCause().toString() : ex.toString();
		ErroMessage msg = new ErroMessage(erro, cause);
		log.error(msg.toString());
		return msg;
	}
	
	@ExceptionHandler(value = { HttpMessageNotReadableException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErroMessage httpMessageNotReadable(HttpMessageNotReadableException ex) {
		String erro = msgSource.getMessage("javax.validation.constraints.Pattern.message", null, LocaleContextHolder.getLocale());
		String cause = ex.getCause() != null ? ex.getCause().toString() : ex.toString();
		ErroMessage msg = new ErroMessage(erro, cause);
		log.error(msg.toString());
		return msg;
	}
	@ExceptionHandler(value = { ConstraintViolationException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErroMessage handlerConstraintViolation(ConstraintViolationException ex) {
		String simples = ErroMessage.simpleMensagem(msgSource, "msg-erro.constraint-violation");
		String completa = ErroMessage.fullMensagem(ex);
		return new ErroMessage(simples, completa);
	}
	
}
