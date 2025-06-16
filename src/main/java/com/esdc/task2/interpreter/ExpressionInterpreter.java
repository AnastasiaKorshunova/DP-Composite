package com.esdc.task2.interpreter;

import java.util.List;

public final class ExpressionInterpreter {
    private final ReversePolishConverter converter = new ReversePolishConverter();
    private final ReversePolishEvaluator evaluator = new ReversePolishEvaluator();

    public double evaluate(String infix) {
        List<String> rpn = converter.toRpn(infix);
        return evaluator.evaluate(rpn);
    }
}