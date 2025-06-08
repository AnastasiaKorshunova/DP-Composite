package com.esdc.task2.exception;

/**
 * Бросается, когда парсер не может корректно разобрать входной текст
 * (неконсистентные скобки, неожиданный символ и т.п.).
 */
public class ParseException extends RuntimeException {
    public ParseException(String message) { super(message); }
    public ParseException(String message, Throwable cause) { super(message, cause); }
}