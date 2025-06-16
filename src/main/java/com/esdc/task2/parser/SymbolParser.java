package com.esdc.task2.parser;

import com.esdc.task2.composite.TextComponent;
import com.esdc.task2.composite.impl.Symbol;

import java.util.ArrayList;
import java.util.List;

public class SymbolParser extends AbstractParser {
    @Override
    public List<TextComponent> parse(String data) {
        List<TextComponent> textComponents = new ArrayList<>();
        for(Character c: data.toCharArray()) {
            textComponents.add(new Symbol(c));
        }
        return textComponents;
    }
}
