package org.serratec.backend.trabalhofinalapi.exception;

@SuppressWarnings("serial")
public class EmailException extends RuntimeException{
	public EmailException(String message) {
		super(message);
	}
}
