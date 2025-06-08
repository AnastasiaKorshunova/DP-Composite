package com.esdc.composite.entity;

public final class Word extends CompositeElement {
    @Override public ElementType getType() { return ElementType.WORD; }
    @Override public String restore() { return glueChildren(""); }
}