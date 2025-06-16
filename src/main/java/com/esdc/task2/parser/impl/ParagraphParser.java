package com.esdc.task2.parser.impl;

import com.esdc.task2.composite.TextComponent;
import com.esdc.task2.composite.impl.Paragraph;
import com.esdc.task2.parser.BaseParser;

import java.util.ArrayList;
import java.util.List;

public class ParagraphParser implements BaseParser {
    private final static String PARAGRAPH_REGEXP = "\\t| {4}";
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
            String trimmedStr = split.trim();
            if (trimmedStr.isEmpty()) {
                continue;
            }
            Paragraph paragraph = new Paragraph();
            if (getNext() != null) {
                getNext().parse(trimmedStr).forEach(paragraph::addChild);
            }
            textComponents.add(paragraph);
        }
        return textComponents;
    }

    @Override
    public BaseParser getNext() {
        return nextBaseParser;
    }


    protected String[] split(String data) {
        return data.split(PARAGRAPH_REGEXP);
    }
}
