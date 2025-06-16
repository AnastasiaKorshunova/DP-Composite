package com.esdc.task2.parser;

import com.esdc.task2.composite.TextComponent;
import com.esdc.task2.composite.impl.Sentence;

import java.util.ArrayList;
import java.util.List;

public class SentenceParser extends AbstractParser {
    private static final String SENTENCE_REGEX = "(?<=[.?!])\\s+(?=[A-Z])";

    @Override
    public List<TextComponent> parse(String data) {
        List<TextComponent> textComponents = new ArrayList<>();
        for (String split : split(data)) {
            Sentence sentence = new Sentence();
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
