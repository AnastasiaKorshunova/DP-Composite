package com.esdc.task2.interpreter;

import java.util.List;

/**
 * Фасад: объединяет конвертацию инфикс‑строки в RPN и её вычисление.
 */
public final class ExpressionInterpreter {
    private final ReversePolishConverter converter = new ReversePolishConverter();
    private final ReversePolishEvaluator evaluator = new ReversePolishEvaluator();

    /**
     * @param infix выражение вида "3+4*2/(1-5)"
     * @return результат вычисления в double
     */
    public double evaluate(String infix) {
        List<String> rpn = converter.toRpn(infix);
        return evaluator.evaluate(rpn);
    }
}