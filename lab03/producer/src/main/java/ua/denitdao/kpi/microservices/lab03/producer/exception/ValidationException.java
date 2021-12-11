package ua.denitdao.kpi.microservices.lab03.producer.exception;

public class ValidationException extends RuntimeException {

    public ValidationException(Throwable cause) {
        super(cause);
    }
}
