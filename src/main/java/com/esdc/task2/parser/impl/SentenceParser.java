package com.esdc.task2.parser.impl;

import com.esdc.task2.composite.TextComponent;
import com.esdc.task2.composite.TextComponentType;
import com.esdc.task2.composite.impl.TextComponentLeaf;
import com.esdc.task2.parser.AbstractBaseParser;

import java.util.ArrayList;
import java.util.List;

public class SentenceParser extends AbstractBaseParser {
    private static final String SENTENCE_REGEX = "(?<=[.?!])\\s+(?=[A-Z])";

    @Override
    public List<TextComponent> parse(String data) {
        List<TextComponent> textComponents = new ArrayList<>();
        for (String split : split(data.replaceAll("\n", ""))) {
            TextComponentLeaf sentence = new TextComponentLeaf(TextComponentType.SENTENCE);
            if (getNext() != null) {
                getNext().parse(split).forEach(sentence::addChild);
            }
            textComponents.add(sentence);
        }
        return textComponents;
    }

    protected String[] split(String data) {
        return data.split(SENTENCE_REGEX);
    }
}
