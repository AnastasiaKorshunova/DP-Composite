package com.esdc.composite.exception;

/**
 * Невозможно вычислить арифметическое выражение (деление на ноль,
 * неизвестный оператор, пустой стек во время RPN‑вычисления, ...).
 */
public class InterpreterException extends RuntimeException {
    public InterpreterException(String message) { super(message); }
    public InterpreterException(String message, Throwable cause) { super(message, cause); }
}
