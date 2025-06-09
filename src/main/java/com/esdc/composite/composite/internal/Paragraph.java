package com.esdc.composite.composite.internal;

import com.esdc.composite.composite.internal.type.ComponentType;
import com.esdc.composite.composite.internal.type.CompositeNode;

/** Paragraph &mdash; list of sentences. */
 final public class Paragraph extends CompositeNode {

    @Override public ComponentType getType() { return ComponentType.PARAGRAPH; }

    @Override public String restore() {
        /* Restore sentences separated by single space, add leading tab. */
        return "\t" + glue(" ") + System.lineSeparator();
    }
}