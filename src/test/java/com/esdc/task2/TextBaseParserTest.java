package com.esdc.task2;

import com.esdc.task2.composite.impl.Text;
import com.esdc.task2.parser.BaseParser;
import com.esdc.task2.parser.impl.LexemeParser;
import com.esdc.task2.parser.impl.ParagraphParser;
import com.esdc.task2.parser.impl.SentenceParser;
import com.esdc.task2.parser.impl.SymbolParser;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TextBaseParserTest {

    @Test
    void testArithmeticParser() throws IOException {
        String textFile = FileUtils.readFile("arithmetic.txt");

        BaseParser paragraphBaseParser = new ParagraphParser();
        paragraphBaseParser.linkWith(new SentenceParser())
                .linkWith(new LexemeParser())
                .linkWith(new SymbolParser());

        Text text = new Text();
        paragraphBaseParser.parse(textFile).forEach(text::addChild);

        System.out.println(text);
    }

    @Test
    void testLightParser() throws IOException {
        String textFile = FileUtils.readFile("light.txt");

        BaseParser paragraphBaseParser = new ParagraphParser();
        paragraphBaseParser.linkWith(new SentenceParser())
                .linkWith(new LexemeParser())
                .linkWith(new SymbolParser());

        Text text = new Text();
        paragraphBaseParser.parse(textFile).forEach(text::addChild);

        System.out.println(text);
    }

    @Test
    void testBitParser() throws IOException {
        String textFile = FileUtils.readFile("bit.txt");

        BaseParser paragraphBaseParser = new ParagraphParser();
        paragraphBaseParser.linkWith(new SentenceParser())
                .linkWith(new LexemeParser())
                .linkWith(new SymbolParser());

        Text text = new Text();
        paragraphBaseParser.parse(textFile).forEach(text::addChild);

        System.out.println(text);
    }
}
