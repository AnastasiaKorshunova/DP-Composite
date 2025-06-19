package com.esdc.task2.interpreter.expressions.impl;

import com.esdc.task2.interpreter.expressions.Expression;

import java.util.function.IntBinaryOperator;

public record Binary(Expression left, IntBinaryOperator operator, Expression right) implements Expression {
    public int interpret() {
        return operator.applyAsInt(left.interpret(), right.interpret());
    }
}
