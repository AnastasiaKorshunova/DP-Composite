package com.esdc.task2.parser.impl;

import com.esdc.task2.composite.TextComponent;
import com.esdc.task2.composite.TextComponentType;
import com.esdc.task2.composite.impl.TextComponentLeaf;
import com.esdc.task2.parser.AbstractBaseParser;

import java.util.ArrayList;
import java.util.List;

public class ParagraphParser extends AbstractBaseParser {
    private final static String PARAGRAPH_REGEXP = "\\t| {4}";

    @Override
    public List<TextComponent> parse(String data) {
        List<TextComponent> textComponents = new ArrayList<>();
        for (String split : split(data)) {
            String trimmedStr = split.trim().replaceAll("\n", "");
            if (trimmedStr.isEmpty()) {
                continue;
            }
            TextComponentLeaf paragraph = new TextComponentLeaf(TextComponentType.PARAGRAPH);
            if (getNext() != null) {
                getNext().parse(trimmedStr).forEach(paragraph::addChild);
            }
            textComponents.add(paragraph);
        }
        return textComponents;
    }

    protected String[] split(String data) {
        return data.split(PARAGRAPH_REGEXP);
    }
}
