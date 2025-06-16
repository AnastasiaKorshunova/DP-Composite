package com.esdc.task2;

import com.esdc.task2.composite.impl.Text;
import com.esdc.task2.parser.AbstractParser;
import com.esdc.task2.parser.LexemeParser;
import com.esdc.task2.parser.ParagraphParser;
import com.esdc.task2.parser.SentenceParser;
import com.esdc.task2.parser.SymbolParser;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TextParserTest {

    @Test
    void testArithmeticParser() throws IOException {
        String textFile = FileUtils.readFile("arithmetic.txt");

        AbstractParser paragraphParser = new ParagraphParser();
        paragraphParser.linkWith(new SentenceParser())
                .linkWith(new LexemeParser())
                .linkWith(new SymbolParser());

        Text text = new Text();
        paragraphParser.parse(textFile).forEach(text::addChild);

        System.out.println(text);
    }

    @Test
    void testLightParser() throws IOException {
        String textFile = FileUtils.readFile("light.txt");

        AbstractParser paragraphParser = new ParagraphParser();
        paragraphParser.linkWith(new SentenceParser())
                .linkWith(new LexemeParser())
                .linkWith(new SymbolParser());

        Text text = new Text();
        paragraphParser.parse(textFile).forEach(text::addChild);

        System.out.println(text);
    }

    @Test
    void testBitParser() throws IOException {
        String textFile = FileUtils.readFile("bit.txt");

        AbstractParser paragraphParser = new ParagraphParser();
        paragraphParser.linkWith(new SentenceParser())
                .linkWith(new LexemeParser())
                .linkWith(new SymbolParser());

        Text text = new Text();
        paragraphParser.parse(textFile).forEach(text::addChild);

        System.out.println(text);
    }
}
