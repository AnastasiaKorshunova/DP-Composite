package com.esdc.composite.composite.internal;

import com.esdc.composite.composite.internal.type.ComponentType;
import com.esdc.composite.composite.internal.type.CompositeNode;

/** Whole text consisting of paragraphs. */
public final class Text extends CompositeNode {

    @Override public ComponentType getType() { return ComponentType.TEXT; }

    @Override public String restore() {
        /* Double line-break between paragraphs. */
        return glue(System.lineSeparator() + System.lineSeparator());
    }
}