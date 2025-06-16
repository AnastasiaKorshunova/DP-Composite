package com.esdc.task2.parser.impl;

import com.esdc.task2.composite.TextComponent;
import com.esdc.task2.composite.impl.Symbol;
import com.esdc.task2.parser.BaseParser;

import java.util.ArrayList;
import java.util.List;

public class SymbolParser implements BaseParser {
    private BaseParser nextBaseParser;

    @Override
    public BaseParser linkWith(BaseParser next) {
        this.nextBaseParser = next;
        return next;
    }

    @Override
    public List<TextComponent> parse(String data) {
        List<TextComponent> textComponents = new ArrayList<>();
        for(Character c: data.toCharArray()) {
            textComponents.add(new Symbol(c));
        }
        return textComponents;
    }

    @Override
    public BaseParser getNext() {
        return nextBaseParser;
    }
}
