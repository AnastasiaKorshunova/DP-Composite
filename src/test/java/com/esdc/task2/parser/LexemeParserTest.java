package com.esdc.task2.parser;

import com.esdc.task2.composite.TextComponent;
import com.esdc.task2.parser.impl.LexemeParser;
import com.esdc.task2.parser.impl.SymbolParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LexemeParserTest {
    LexemeParser parser;

    @BeforeEach
    void setUp() {
        parser = new LexemeParser();
        parser.linkWith(new SymbolParser());
    }

    @Test
    void shouldParseSingleLexeme() {
        LexemeParser parser = new LexemeParser();
        List<TextComponent> result = parser.parse("hello");
        assertEquals(1, result.size());
    }

    @Test
    void shouldParseMultipleLexemes() {
        List<TextComponent> result = parser.parse("hello world");
        assertEquals(2, result.size());
    }

    @Test
    void shouldEvaluateMathExpression() {
        List<TextComponent> result = parser.parse("2+3");
        assertEquals(1, result.size());
        assertEquals("5", result.get(0).toString());
    }

    @Test
    void shouldEvaluateBinaryExpression() {
        List<TextComponent> result = parser.parse("2<<1");
        assertEquals(1, result.size());
        assertEquals("4", result.get(0).toString());
    }
}
