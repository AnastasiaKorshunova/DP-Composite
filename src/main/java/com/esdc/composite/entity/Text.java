package com.esdc.composite.entity;

public final class Text extends CompositeElement {
    @Override public ElementType getType() { return ElementType.TEXT; }
    @Override public String restore() {
        return glueChildren(System.lineSeparator() + System.lineSeparator());
    }
}
