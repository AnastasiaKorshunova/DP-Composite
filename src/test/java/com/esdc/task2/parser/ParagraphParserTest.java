package com.esdc.task2.parser;

import com.esdc.task2.composite.TextComponent;
import com.esdc.task2.composite.TextComponentType;
import com.esdc.task2.composite.impl.TextComponentLeaf;
import com.esdc.task2.parser.impl.ParagraphParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParagraphParserTest {

    ParagraphParser parser;

    @BeforeEach
    void setUp() {
        parser = new ParagraphParser();
    }

    @Test
    void parseShouldCreateParagraphComponents() {
        ParagraphParser parser = new ParagraphParser();
        List<TextComponent> result = parser.parse("para1\tpara2    para3");
        assertEquals(3, result.size());
        for (TextComponent tc : result) {
            assertInstanceOf(TextComponentLeaf.class, tc);
            assertEquals(TextComponentType.PARAGRAPH, tc.getType());
        }
    }

    @Test
    void parseShouldSkipEmptyEntries() {
        ParagraphParser parser = new ParagraphParser();
        List<TextComponent> result = parser.parse("\t    ");
        assertTrue(result.isEmpty());
    }
}
