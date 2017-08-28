package br.com.doglife.exception;

public class InativeUserException extends LoginException {
    public InativeUserException(String message) {
        super(message);
    }
}
