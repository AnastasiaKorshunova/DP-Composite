package com.esdc.composite.composite.internal;

import com.esdc.composite.composite.internal.type.ComponentType;

/**
 * A lexeme: sequence of symbols bounded by white-spaces.
 * May contain letters, digits, punctuation.
 */
 final public class Lexeme extends CompositeNode {

    @Override public ComponentType getType() { return ComponentType.LEXEME; }

    @Override public String restore() {
        /* No delimiter between child symbols. */
        return glue("");
    }
}