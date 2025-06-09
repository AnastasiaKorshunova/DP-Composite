package com.esdc.composite.composite.internal;

import com.esdc.composite.composite.internal.type.ComponentType;
import com.esdc.composite.composite.internal.type.CompositeNode;

/**
 * Sentence is a collection of lexemes followed by sentence terminator
 * ('.', '?', '!' or '…').
 */
 final class Sentence extends CompositeNode {

    @Override public ComponentType getType() { return ComponentType.SENTENCE; }

    @Override public String restore() {
        /* Single space between lexemes. */
        return glue(" ").trim();
    }
}