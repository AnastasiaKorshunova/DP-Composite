package com.esdc.task2.composite.impl;

import com.esdc.task2.composite.TextComponent;
import com.esdc.task2.composite.TextComponentType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TextComponentLeaf implements TextComponent {

    private final TextComponentType type;
    private final List<TextComponent> children = new ArrayList<>();

    public TextComponentLeaf(TextComponentType type) {
        this.type = type;
    }

    @Override
    public TextComponentType getType() {
        return type;
    }

    @Override
    public boolean removeComponent(TextComponent component) {
        return children.remove(component);
    }

    @Override
    public void addChild(TextComponent component) {
        children.add(component);
    }

    @Override
    public List<TextComponent> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return children.stream()
                .map(TextComponent::toString)
                .collect(Collectors.joining(type.getDelimiter()));
    }
}
