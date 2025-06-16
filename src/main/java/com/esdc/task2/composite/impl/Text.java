package com.esdc.task2.composite.impl;

import com.esdc.task2.composite.TextComponent;
import com.esdc.task2.composite.TextComponentType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Text implements TextComponent {

    private final List<TextComponent> children = new ArrayList<>();
    private final TextComponentType type = TextComponentType.TEXT;

    public Text() {

    }

    public void addChild(TextComponent child) {
        Objects.requireNonNull(child, "Child component cannot be null");
        children.add(child);
    }

    @Override
    public int length() {
        return children.size();
    }

    @Override
    public TextComponentType getType() {
        return type;
    }

    @Override
    public List<TextComponent> getComponents(TextComponentType type) {
        if (type == TextComponentType.TEXT) {
            return List.of(this);
        }
        return children.stream().flatMap(m -> m.getComponents(type).stream()).collect(Collectors.toList());
    }

    @Override
    public boolean removeComponent(TextComponent component) {
        return children.remove(component);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Text other)) return false;
        return type == other.type && Objects.equals(children, other.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, children);
    }

    @Override
    public String toString() {
        return children.stream()
                .map(TextComponent::toString)
                .collect(Collectors.joining(""));
    }
}
