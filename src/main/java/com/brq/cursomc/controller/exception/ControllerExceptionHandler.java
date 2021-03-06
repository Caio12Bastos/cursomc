package com.brq.cursomc.controller.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.brq.cursomc.services.exception.RecursoNaoEncontrado;
@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(RecursoNaoEncontrado.class)
	public ResponseEntity<MensagemErro> recursoNaoEncontrado(RecursoNaoEncontrado excecao, HttpServletRequest request) {
		
		MensagemErro mensagemErro = new MensagemErro(
				HttpStatus.NOT_FOUND.value(), excecao.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagemErro);
	}
}
