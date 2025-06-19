package com.esdc.task2.interpreter;

public class ExpressionInterpreter {

    public int evaluate(String expr) {
        return new Parser(expr).parse().interpret();
    }
}
