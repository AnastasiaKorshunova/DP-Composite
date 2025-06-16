package com.esdc.task2.composite.impl;

import com.esdc.task2.composite.TextComponent;
import com.esdc.task2.composite.TextComponentType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Word implements TextComponent {

    private final List<TextComponent> children = new ArrayList<>();
    private final TextComponentType type = TextComponentType.WORD;

    public Word() {
    }

    @Override
    public TextComponentType getType() {
        return type;
    }

    @Override
    public int length() {
        return children.size();
    }

    @Override
    public List<TextComponent> getComponents(TextComponentType type) {
        if (type == TextComponentType.WORD) {
            return List.of(this);
        }
        return children.stream().flatMap(m -> m.getComponents(type).stream()).collect(Collectors.toList());
    }

    @Override
    public boolean removeComponent(TextComponent component) {
        if (component.getType() == TextComponentType.SYMBOL) {
            return children.remove(component);
        }
        return false;
    }

    @Override
    public void addChild(TextComponent component) {
        children.add(component);
    }

    public String toString() {
        return children.stream()
                .map(TextComponent::toString)
                .collect(Collectors.joining(""));
    }
}
