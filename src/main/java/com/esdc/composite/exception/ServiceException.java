package com.esdc.composite.exception;

/**
 * Ошибки уровня сервис‑операций: попытка удалить предложение,
 * которого нет, передан некорректный параметр (minWords &lt; 0) и т.д.
 */
public class ServiceException extends RuntimeException {
    public ServiceException(String message) { super(message); }
    public ServiceException(String message, Throwable cause) { super(message, cause); }
}