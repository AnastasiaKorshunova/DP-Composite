package com.esdc.task2.parser.impl;

import com.esdc.task2.composite.TextComponent;
import com.esdc.task2.composite.impl.TextComponentSymbol;
import com.esdc.task2.parser.AbstractBaseParser;

import java.util.ArrayList;
import java.util.List;

public class SymbolParser extends AbstractBaseParser {

    @Override
    public List<TextComponent> parse(String data) {
        List<TextComponent> textComponents = new ArrayList<>();
        for (Character c : data.toCharArray()) {
            textComponents.add(new TextComponentSymbol(c));
        }
        return textComponents;
    }
}
