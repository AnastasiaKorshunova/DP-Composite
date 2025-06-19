package com.esdc.task2.parser;

import com.esdc.task2.composite.TextComponent;
import com.esdc.task2.composite.TextComponentType;
import com.esdc.task2.composite.impl.TextComponentLeaf;
import com.esdc.task2.parser.impl.LexemeParser;
import com.esdc.task2.parser.impl.SentenceParser;
import com.esdc.task2.parser.impl.SymbolParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class SentenceParserTest {
    SentenceParser parser;

    @BeforeEach
    void setUp() {
        parser = new SentenceParser();
        LexemeParser lexemeParser = new LexemeParser();
        parser.linkWith(lexemeParser);
        lexemeParser.linkWith(new SymbolParser());
    }

    @Test
    void parseShouldCreateSentenceComponents() {
        List<TextComponent> result = parser.parse("First sentence. Second sentence? Third!");
        assertEquals(3, result.size());
        for (TextComponent tc : result) {
            assertInstanceOf(TextComponentLeaf.class, tc);
            assertEquals(TextComponentType.SENTENCE, tc.getType());
        }
    }

    @Test
    void parseShouldRemoveNewlines() {
        List<TextComponent> result = parser.parse("Hello\nWorld. Hi");
        assertEquals(2, result.size());
        assertEquals("HelloWorld.", result.get(0).toString());
        assertEquals("Hi", result.get(1).toString());
    }
}
