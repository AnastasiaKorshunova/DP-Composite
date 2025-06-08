package com.esdc.composite.entity;

import java.util.List;

public final class Symbol extends Element {
    private final char value;

    public Symbol(char value) { this.value = value; }

    @Override public ElementType getType() { return ElementType.SYMBOL; }
    @Override public String restore() { return String.valueOf(value); }

    /* forbid structural ops */
    @Override public void add(Element c) { throw new UnsupportedOperationException(); }
    @Override public void remove(Element c) { throw new UnsupportedOperationException(); }
    @Override public List<Element> getChildren() { return List.of(); }

    public char getValue() { return value; }
}
