package com.esdc.composite.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Предок для Paragraph, Sentence, Lexeme, Word, Text.
 * Только он реально содержит список дочерних компонентов.
 */
public abstract class CompositeElement extends Element {

    private final List<Element> children = new ArrayList<>();

    @Override
    public void add(Element child) {
        children.add(Objects.requireNonNull(child));
    }

    @Override
    public void remove(Element child) {
        children.remove(child);
    }

    @Override
    public List<Element> getChildren() {
        return Collections.unmodifiableList(children);
    }

    /** Быстро склеиваем restore() всех детей. */
    @Override
    protected String glueChildren(String delimiter) {
        return children.stream()
                .map(Element::restore)
                .collect(Collectors.joining(delimiter));
    }
}

