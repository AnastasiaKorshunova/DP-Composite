package com.esdc.task2.parser;

import com.esdc.task2.composite.TextComponent;
import com.esdc.task2.composite.impl.TextComponentSymbol;
import com.esdc.task2.parser.impl.SymbolParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SymbolParserTest {
    SymbolParser parser;

    @BeforeEach
    public void setup() {
        parser = new SymbolParser();
    }

    @Test
    void parseShouldReturnSymbolComponents() {
        List<TextComponent> result = parser.parse("a!2");
        assertEquals(3, result.size());
        assertInstanceOf(TextComponentSymbol.class, result.get(0));
        assertEquals("a", result.get(0).toString());
        assertInstanceOf(TextComponentSymbol.class, result.get(1));
        assertEquals("!", result.get(1).toString());
        assertInstanceOf(TextComponentSymbol.class, result.get(2));
        assertEquals("2", result.get(2).toString());
    }

    @Test
    void parseEmptyStringShouldReturnEmptyList() {
        List<TextComponent> result = parser.parse("");
        assertTrue(result.isEmpty());
    }
}
