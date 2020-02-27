package com.matrix.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public final class ErroMessage {
	private String erro;
	private String cause;
	private List<ErroMessage> erros = new ArrayList<>();

	public static String simpleMensagem(MessageSource messageSource, String message) {
		return messageSource.getMessage(message, null, LocaleContextHolder.getLocale());
	}

	public static String fullMensagem(Exception ex) {
		return ex.getCause() != null ? ex.getCause().toString() : ex.toString();
	}

	public ErroMessage(String erro, String causa) {
		super();
		this.erro = erro;
		this.cause = causa;
	}

}
