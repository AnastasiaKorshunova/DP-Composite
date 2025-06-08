package com.esdc.composite.entity;

public final class Lexeme extends CompositeElement {
    @Override public ElementType getType() { return ElementType.LEXEME; }
    @Override public String restore() { return glueChildren(" "); }
}
