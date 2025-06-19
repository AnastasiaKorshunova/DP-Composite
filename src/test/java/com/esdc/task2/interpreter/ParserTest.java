package com.esdc.task2.interpreter;

import com.esdc.task2.interpreter.expressions.Expression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {

    private int eval(String expr) {
        Expression e = new Parser(expr).parse();
        return e.interpret();
    }

    @Test
    void shouldEvaluateLiteral() {
        assertEquals(42, eval("42"));
    }

    @Test
    void shouldEvaluateBasicArithmetic() {
        assertEquals(5, eval("2+3"));
        assertEquals(-1, eval("2-3"));
        assertEquals(6, eval("2*3"));
        assertEquals(2, eval("6/3"));
    }

    @Test
    void shouldRespectPrecedence() {
        assertEquals(14, eval("2+3*4"));
        assertEquals(20, eval("(2+3)*4"));
    }

    @Test
    void shouldEvaluateBitwiseOperators() {
        assertEquals(3, eval("1|2"));
        assertEquals(1, eval("3&1"));
        assertEquals(2, eval("1^3"));
    }

    @Test
    void shouldEvaluateShifts() {
        assertEquals(4, eval("1<<2"));
        assertEquals(4, eval("8>>1"));
    }

    @Test
    void shouldEvaluateUnaryOperators() {
        assertEquals(-3, eval("-3"));
        assertEquals(3, eval("+3"));
        assertEquals(-1, eval("~0"));
        assertEquals(4, eval("++3"));
        assertEquals(2, eval("--3"));
        assertEquals(4, eval("3++"));
        assertEquals(2, eval("3--"));
    }

    @Test
    void shouldCombineUnaryAndBinary() {
        assertEquals(3, eval("-2+5"));
        assertEquals(-1, eval("1+~1"));
    }
}
