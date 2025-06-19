package com.esdc.task2.interpreter;

import com.esdc.task2.interpreter.expressions.impl.Binary;
import com.esdc.task2.interpreter.expressions.Expression;
import com.esdc.task2.interpreter.expressions.impl.Literal;
import com.esdc.task2.interpreter.expressions.impl.Unary;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;

public class Parser {
    private final Lexer lexer;
    private Token look;

    Parser(String s) {
        lexer = new Lexer(s);
        look = lexer.next();
    }

    Expression parse() {
        return expr();
    }

    private Expression expr() {
        return or();
    }

    private Expression or() {
        return left(this::xor, "|");
    }

    private Expression xor() {
        return left(this::and, "^");
    }

    private Expression and() {
        return left(this::shift, "&");
    }

    private Expression shift() {
        return left(this::add, "<<", ">>");
    }

    private Expression add() {
        return left(this::mul, "+", "-");
    }

    private Expression mul() {
        return left(this::unary, "*", "/");
    }

    private Expression unary() {
        if (match("+", "-", "~", "++", "--")) {
            String opTxt = consume().text();

            IntUnaryOperator operator = switch (opTxt) {
                case "+" -> v -> +v;
                case "-" -> v -> -v;
                case "~" -> v -> ~v;
                case "++" -> v -> v + 1;
                case "--" -> v -> v - 1;
                default -> throw new AssertionError(opTxt);
            };
            return new Unary(operator, unary());
        }
        return postfix();
    }

    private Expression postfix() {
        Expression base = primary();
        if (match("++", "--")) {
            String opTxt = consume().text();
            IntUnaryOperator sideEffect = opTxt.equals("++") ? v -> v + 1 : v -> v - 1;
            return new Unary(v -> v, new Unary(sideEffect, base)); // two-step
        }
        return base;
    }

    private Expression primary() {
        if (look.kind() == Kind.NUMBER) {
            return new Literal(Integer.parseInt(consume().text()));
        }
        if (look.kind() == Kind.LPARENTHESIS) {
            consume();
            Expression inside = expr();
            consume();
            return inside;
        }
        throw new RuntimeException("Unexpected token: " + look.text());
    }

    private Expression left(Supplier<Expression> sub, String... ops) {
        Expression expression = sub.get();
        while (match(ops)) {
            String operatorText = consume().text();
            IntBinaryOperator operator = switch (operatorText) {
                case "|" -> (a, b) -> a | b;
                case "^" -> (a, b) -> a ^ b;
                case "&" -> (a, b) -> a & b;
                case "<<" -> (a, b) -> a << b;
                case ">>" -> (a, b) -> a >> b;
                case "+" -> Integer::sum;
                case "-" -> (a, b) -> a - b;
                case "*" -> (a, b) -> a * b;
                case "/" -> (a, b) -> a / b;
                default -> throw new AssertionError(operatorText);
            };
            expression = new Binary(expression, operator, sub.get());
        }
        return expression;
    }

    private boolean match(String... ops) {
        return look.kind() == Kind.OPERATION && Arrays.asList(ops).contains(look.text());
    }

    private Token consume() {
        Token t = look;
        look = lexer.next();
        return t;
    }
}
