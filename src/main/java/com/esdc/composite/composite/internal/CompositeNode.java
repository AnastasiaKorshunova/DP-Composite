package com.esdc.composite.composite.internal;

import com.esdc.composite.composite.TextComponent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Common logic for every <i>container</i> node
 * (TEXT, PARAGRAPH, SENTENCE, LEXEME &mdash; anything that can have children).
 */
abstract public class CompositeNode implements TextComponent {

    private final List<TextComponent> children = new ArrayList<>();

    @Override public void add(TextComponent child) {
        children.add(Objects.requireNonNull(child));
    }

    @Override public void remove(TextComponent child) {
        children.remove(child);
    }

    @Override public List<TextComponent> getChildren() {
        return Collections.unmodifiableList(children);
    }

    /**
     * Glue helper used by concrete subclasses in their {@link #restore()}.
     */
    protected String glue(String delimiter) {
        return children.stream()
                .map(TextComponent::restore)
                .collect(Collectors.joining(delimiter));
    }
}