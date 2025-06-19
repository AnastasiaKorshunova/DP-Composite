package com.esdc.task2.composite.impl;

import com.esdc.task2.composite.TextComponent;
import com.esdc.task2.composite.TextComponentType;

import java.util.List;

public class TextComponentSymbol implements TextComponent {

    private final char character;

    public TextComponentSymbol(char character) {
        this.character = character;
    }

    @Override
    public TextComponentType getType() {
        return TextComponentType.SYMBOL;
    }

    @Override
    public boolean removeComponent(TextComponent component) {
        throw new UnsupportedOperationException("Cannot remove symbol element");
    }

    @Override
    public void addChild(TextComponent component) {
        throw new UnsupportedOperationException("Cannot add child to the symbol element");
    }

    @Override
    public List<TextComponent> getChildren() {
        throw new UnsupportedOperationException("Cannot get children of the symbol element");
    }

    @Override
    public String toString() {
        return String.valueOf(character);
    }
}

