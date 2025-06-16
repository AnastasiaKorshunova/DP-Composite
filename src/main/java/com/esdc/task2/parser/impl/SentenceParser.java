package com.esdc.task2.parser.impl;

import com.esdc.task2.composite.TextComponent;
import com.esdc.task2.composite.impl.Sentence;
import com.esdc.task2.parser.BaseParser;

import java.util.ArrayList;
import java.util.List;

public class SentenceParser implements BaseParser {
    private static final String SENTENCE_REGEX = "(?<=[.?!])\\s+(?=[A-Z])";
    private BaseParser nextBaseParser;

    @Override
    public BaseParser linkWith(BaseParser next) {
        this.nextBaseParser = next;
        return next;
    }

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

    @Override
    public BaseParser getNext() {
        return nextBaseParser;
    }

    protected String[] split(String data) {
        return data.split(SENTENCE_REGEX);
    }
}
