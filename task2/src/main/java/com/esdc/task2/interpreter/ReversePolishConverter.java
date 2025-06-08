package com.esdc.task2.interpreter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;

/**
 * Преобразует инфиксную строку (например, "3+4*2/(1-5)") в список токенов
 * в <strong>обратной польской нотации</strong> (RPN) с помощью алгоритма Дейкстры.
 */
public final class ReversePolishConverter {

    private static final Map<String, Integer> PRIORITY = Map.of(
            "+", 1, "-", 1,
            "*", 2, "/", 2,
            "(", 0, ")", 0
    );

    /**
     * @return список токенов в порядке RPN (готов для стек‑вычисления)
     */
    public List<String> toRpn(String infixExpr) {
        List<String> output = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();

        // простой сканер по символам (упрощённо: числа целые, операторы + - * /, скобки)
        StringBuilder number = new StringBuilder();
        for (char ch : infixExpr.replaceAll("\\s+", "").toCharArray()) {
            if (Character.isDigit(ch)) {
                number.append(ch);
            } else {
                if (number.length() > 0) {  // сброс накопленного числа
                    output.add(number.toString());
                    number.setLength(0);
                }
                String token = String.valueOf(ch);
                switch (token) {
                    case "(":
                        stack.push(token);
                        break;
                    case ")":
                        while (!stack.isEmpty() && !"(".equals(stack.peek())) {
                            output.add(stack.pop());
                        }
                        if (!stack.isEmpty() && "(".equals(stack.peek())) stack.pop();
                        break;
                    default: // оператор
                        while (!stack.isEmpty() && PRIORITY.get(token) <= PRIORITY.get(stack.peek())) {
                            output.add(stack.pop());
                        }
                        stack.push(token);
                }
            }
        }
        if (number.length() > 0) output.add(number.toString());
        while (!stack.isEmpty()) output.add(stack.pop());
        return output;
    }
}