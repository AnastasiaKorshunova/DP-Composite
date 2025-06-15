package com.esdc.task2.interpreter;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;

/**
 * Вычисляет значение выражения, представленного списком токенов в RPN.
 */
public final class ReversePolishEvaluator {

    private static final Map<String, java.util.function.BiFunction<Double, Double, Double>> BIN_OP = Map.of(
            "+", (a, b) -> a + b,
            "-", (a, b) -> a - b,
            "*", (a, b) -> a * b,
            "/", (a, b) -> a / b
    );

    public double evaluate(List<String> rpnTokens) {
        Deque<Double> stack = new ArrayDeque<>();
        for (String tok : rpnTokens) {
            if (BIN_OP.containsKey(tok)) {
                double b = stack.pop();
                double a = stack.pop();
                stack.push(BIN_OP.get(tok).apply(a, b));
            } else {
                stack.push(Double.valueOf(tok));
            }
        }
        return stack.pop();
    }
}