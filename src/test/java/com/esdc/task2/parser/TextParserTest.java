package com.esdc.task2.parser;

import com.esdc.task2.FileUtils;
import com.esdc.task2.composite.TextComponentType;
import com.esdc.task2.composite.impl.TextComponentLeaf;
import com.esdc.task2.parser.impl.LexemeParser;
import com.esdc.task2.parser.impl.ParagraphParser;
import com.esdc.task2.parser.impl.SentenceParser;
import com.esdc.task2.parser.impl.SymbolParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TextParserTest {
    private static final String ARITHMETIC_TEXT = """
            It has survived - not only (five) centuries, but also the leap into electronic typesetting,remaining -8 essentially 7 unchanged. It was popularised in the -880 with the release of Letraset sheets containing Lorem Ipsum passages,and more recently with desktop publishing software like Aldus PageMaker including versions ofLorem Ipsum.
            It is a long established fact that a reader will be distracted by the readable content of a pagewhen looking at its layout. The point of using -9 Ipsum is that it hasa more-or-less normal distribution of letters, as opposed to using (Content here), content here',making it look like readable English.
            It is a -329 established fact that a reader will be of a page when lookingat its layout.
            Bye.""";
    private static final String BIT_TEXT = """
            It has survived - not only (five) centuries, but also the leap into 14 + 3 electronictypesetting, remaining 0 essentially 9 unchanged. It was popularised in the5|(1&2&(3|(4&(1^5|6&47)|3)|(~89&4|(42&7)))|1) with the release of Letraset sheets containingLorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMakerincluding versions of Lorem Ipsum.
            It is a long established fact that a reader will be distracted by the readable content of a pagewhen looking at its layout. The point of using 78 Ipsum is thatit has a more-or-less normal distribution of letters, as opposed to using (Content here), content here',making it look like readable English.
            It is a 1202 established fact that a reader will be of a page whenlooking at its layout.
            Bye.""";
    private static final String LIGHT_TEXT = """
            It has survived - not only (five) centuries, but also the leap into electronic typesetting,remaining essentially unchanged. It was popularised in the “Динамо” (Рига) with therelease of Letraset sheets.toString() containing Lorem Ipsum passages, and more recentlywith desktop publishing software like Aldus PageMaker Faclon9 including versions ofLorem Ipsum!
            It is a long a!=b established fact that a reader will be distracted by the readablecontent of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), contenthere's, making it look like readable English?
            It is a established fact that a reader will be of a page when looking at its layout...
            Bye бандерлоги.""";
    private AbstractBaseParser parser;

    @BeforeEach
    void setUp() {
        parser = new ParagraphParser();
        parser.linkWith(new SentenceParser())
                .linkWith(new LexemeParser())
                .linkWith(new SymbolParser());
    }

    @Test
    void testArithmeticParser() throws IOException {
        String textFile = FileUtils.readFile("arithmetic.txt");

        TextComponentLeaf text = new TextComponentLeaf(TextComponentType.TEXT);
        parser.parse(textFile).forEach(text::addChild);

        Assertions.assertEquals(ARITHMETIC_TEXT, text.toString());
    }

    @Test
    void testLightParser() throws IOException {
        String textFile = FileUtils.readFile("light.txt");

        TextComponentLeaf text = new TextComponentLeaf(TextComponentType.TEXT);
        parser.parse(textFile).forEach(text::addChild);

        Assertions.assertEquals(LIGHT_TEXT, text.toString());
    }

    @Test
    void testBitParser() throws IOException {
        String textFile = FileUtils.readFile("bit.txt");

        TextComponentLeaf text = new TextComponentLeaf(TextComponentType.TEXT);
        parser.parse(textFile).forEach(text::addChild);

        Assertions.assertEquals(BIT_TEXT, text.toString());
    }
}
