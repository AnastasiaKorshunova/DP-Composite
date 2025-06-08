package com.esdc.composite.entity;

public final class Sentence extends CompositeElement {
    @Override public ElementType getType() { return ElementType.SENTENCE; }
    @Override public String restore() {
        return glueChildren(" ").trim(); // знаки препинания лежат собственными лексемами
    }
}