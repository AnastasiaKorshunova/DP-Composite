package com.esdc.task2.composite.impl;

import com.esdc.task2.composite.TextComponent;
import com.esdc.task2.composite.TextComponentType;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Symbol implements TextComponent {

    private final char character;
    private final TextComponentType type = TextComponentType.SYMBOL;

    public Symbol(char character) {
        this.character = character;
    }

    @Override
    public TextComponentType getType() {
        return type;
    }

    @Override
    public int length() {
        return 1;
    }

    @Override
    public List<TextComponent> getComponents(TextComponentType type) {
        return Collections.emptyList();
    }

    @Override
    public boolean removeComponent(TextComponent component) {
        return false;
    }

    @Override
    public void addChild(TextComponent component) {
        //
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Symbol other)) return false;
        return character == other.character;
    }

    @Override
    public int hashCode() {
        return Objects.hash(character);
    }

    @Override
    public String toString() {
        return String.valueOf(character);
    }

}

