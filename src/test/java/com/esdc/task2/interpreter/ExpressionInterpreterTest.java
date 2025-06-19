package com.esdc.task2.interpreter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpressionInterpreterTest {
    private final ExpressionInterpreter interpreter = new ExpressionInterpreter();

    @Test
    void shouldEvaluateComplexArithmetic() {
        assertEquals(13, interpreter.evaluate("2+3*4-5/5"));
    }

    @Test
    void shouldEvaluateNestedBitwiseAndShifts() {
        assertEquals(15, interpreter.evaluate("((2+3)<<1)^5"));
    }

    @Test
    void shouldEvaluateComplexUnaryPostfixPrefix() {
        assertEquals(9, interpreter.evaluate("3++ + ++4"));
    }

    @Test
    void shouldEvaluateExpressionWithParenthesesAndUnary() {
        assertEquals(-14, interpreter.evaluate("-(3+4)*2"));
        assertEquals(-9, interpreter.evaluate("~(1<<3)"));
    }
}
