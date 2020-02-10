package com.gocamargo.exception;

public class ConnectionException extends RuntimeException {

    public ConnectionException(Throwable cause) {
        super("Não foi possível efetuar a conexão.", cause);
    }
}
