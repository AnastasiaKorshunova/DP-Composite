package com.esdc.task2.entity;

public final class Lexeme extends CompositeElement {
    @Override public ElementType getType() { return ElementType.LEXEME; }
    @Override public String restore() { return glueChildren(" "); }
}
