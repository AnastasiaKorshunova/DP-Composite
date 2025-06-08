package com.esdc.composite.entity;

public final class Paragraph extends CompositeElement {
    @Override public ElementType getType() { return ElementType.PARAGRAPH; }
    @Override public String restore() {
        return "\t" + glueChildren(" ").trim();
    }
}
