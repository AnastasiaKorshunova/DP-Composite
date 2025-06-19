package com.esdc.task2.interpreter.expressions.impl;

import com.esdc.task2.interpreter.expressions.Expression;

public record Literal(int value) implements Expression {
    public int interpret() {
        return value;
    }
}
