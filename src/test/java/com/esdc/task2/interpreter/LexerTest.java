package com.esdc.task2.interpreter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LexerTest {

    @Test
    void shouldReturnEofForEmptyAndWhitespace() {
        Lexer lexer = new Lexer("   ");
        Token token = lexer.next();
        assertEquals(Kind.EOF, token.kind());
        assertEquals("", token.text());
    }

    @Test
    void shouldLexNumber() {
        Lexer lexer = new Lexer("12345");
        Token token = lexer.next();
        assertEquals(Kind.NUMBER, token.kind());
        assertEquals("12345", token.text());
        Token eof = lexer.next();
        assertEquals(Kind.EOF, eof.kind());
    }

    @Test
    void shouldLexSingleCharOperators() {
        String ops = "+-*/&|^~";
        for (char c : ops.toCharArray()) {
            Lexer lexer = new Lexer(Character.toString(c));
            Token token = lexer.next();
            assertEquals(Kind.OPERATION, token.kind());
            assertEquals(Character.toString(c), token.text());
            assertEquals(Kind.EOF, lexer.next().kind());
        }
    }

    @Test
    void shouldLexTwoCharOperands() {
        String[] ops = {"<<", ">>", "++", "--"};
        for (String op : ops) {
            Lexer lexer = new Lexer(op);
            Token token = lexer.next();
            assertEquals(Kind.OPERATION, token.kind());
            assertEquals(op, token.text());
            assertEquals(Kind.EOF, lexer.next().kind());
        }
    }

    @Test
    void shouldLexParentheses() {
        Lexer lexer = new Lexer("()");
        Token left = lexer.next();
        assertEquals(Kind.LPARENTHESIS, left.kind());
        assertEquals("(", left.text());
        Token right = lexer.next();
        assertEquals(Kind.RPARENTHESIS, right.kind());
        assertEquals(")", right.text());
        assertEquals(Kind.EOF, lexer.next().kind());
    }

    @Test
    void shouldLexMixedSequence() {
        Lexer lexer = new Lexer("12 + 3");
        Token t1 = lexer.next();
        assertEquals(Kind.NUMBER, t1.kind());
        assertEquals("12", t1.text());
        Token plus = lexer.next();
        assertEquals(Kind.OPERATION, plus.kind());
        assertEquals("+", plus.text());
        Token t2 = lexer.next();
        assertEquals(Kind.NUMBER, t2.kind());
        assertEquals("3", t2.text());
        assertEquals(Kind.EOF, lexer.next().kind());
    }
}
