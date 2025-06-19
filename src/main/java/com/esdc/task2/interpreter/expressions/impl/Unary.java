package com.esdc.task2.interpreter.expressions.impl;

import com.esdc.task2.interpreter.expressions.Expression;

import java.util.function.IntUnaryOperator;

public record Unary(IntUnaryOperator operator, Expression right) implements Expression {
    public int interpret() {
        return operator.applyAsInt(right.interpret());
    }
}
