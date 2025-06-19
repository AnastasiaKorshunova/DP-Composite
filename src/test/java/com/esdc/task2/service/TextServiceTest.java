package com.esdc.task2.service;

import com.esdc.task2.comparator.SentenceCountComparator;
import com.esdc.task2.composite.TextComponent;
import com.esdc.task2.parser.AbstractBaseParser;
import com.esdc.task2.parser.impl.LexemeParser;
import com.esdc.task2.parser.impl.ParagraphParser;
import com.esdc.task2.parser.impl.SentenceParser;
import com.esdc.task2.parser.impl.SymbolParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextServiceTest {

    private final static String TEXT = """
            \tIt is a new word paragraph.
                \tAll it is a new word paragraph. Two sentences.
                \tAaaaa aaaaa aaaa aaa aa a.
            """;
    private final TextService textService = new TextService();
    private AbstractBaseParser parser;

    @BeforeEach
    void setUp() {
        parser = new ParagraphParser();
        parser.linkWith(new SentenceParser())
                .linkWith(new LexemeParser())
                .linkWith(new SymbolParser());
    }

    @Test
    void testSameWordsCount() {
        List<TextComponent> paragraphs = parser.parse(TEXT);

        Map<String, Integer> map = textService.getTheSameWordsAndCount(paragraphs);
        assertEquals(13, map.size());
        assertEquals(1, map.get("aa"));
        assertEquals(1, map.get("aaa"));
        assertEquals(3, map.get("a"));
        assertEquals(2, map.get("it"));
        assertEquals(2, map.get("new"));
    }

    @Test
    void testRemoveSentencesWithWordsLessThanThreshold() {
        List<TextComponent> paragraphs = parser.parse(TEXT);

        List<TextComponent> textComponents = textService.removeSentencesWithWordsLessThanThreshold(paragraphs, 7);

        assertEquals(1, textComponents.size());
        assertEquals("All it is a new word paragraph.", textComponents.get(0).toString());
    }

    @Test
    void testGetSentencesWithTheLongestWord() {
        List<TextComponent> paragraphs = parser.parse(TEXT);

        List<TextComponent> textComponents = textService.getSentencesWithTheLongestWord(paragraphs);
        assertEquals(3, textComponents.size());
    }

    @Test
    void testParagraphSort() {
        List<TextComponent> paragraphs = parser.parse(TEXT);

        List<TextComponent> textComponents = textService.paragraphSort(paragraphs, new SentenceCountComparator());
        assertEquals("All it is a new word paragraph. Two sentences.", textComponents.get(2).toString());
    }

    @Test
    void testCountVowelConsonant() {
        List<TextComponent> paragraphs = parser.parse(TEXT);

        TextService.VowelConsonant allVowels = textService.countVowelConsonant(paragraphs.get(2).getChildren().get(0));
        TextService.VowelConsonant vowelsAndConsonant = textService.countVowelConsonant(paragraphs.get(0).getChildren().get(0));

        assertEquals(new TextService.VowelConsonant(20,0), allVowels);
        assertEquals(new TextService.VowelConsonant(8,13), vowelsAndConsonant);
    }


}
