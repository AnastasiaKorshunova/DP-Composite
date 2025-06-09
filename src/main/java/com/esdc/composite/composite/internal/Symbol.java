// File: src/main/java/com/esdc/composite/composite/internal/leaf/Symbol.java
package com.esdc.composite.composite.internal;

import com.esdc.composite.composite.TextComponent;
import com.esdc.composite.composite.internal.type.ComponentType;
import com.esdc.composite.composite.internal.type.SymbolType;

public class Symbol implements TextComponent {

    private final char value;
    private final SymbolType kind;

    public Symbol(char value, SymbolType kind) {
        this.value = value;
        this.kind  = kind;
    }

    /**
     * Factory method: auto-detects kind from the char
     * (digit → NUMBER, letter → LETTER, otherwise → PUNCTUATION).
     */
    public static Symbol of(char c) {
        SymbolType kind = Character.isDigit(c)   ? SymbolType.NUMBER
                : Character.isLetter(c)? SymbolType.LETTER
                : SymbolType.PUNCTUATION;
        return new Symbol(c, kind);
    }

    @Override
    public ComponentType getType() {
        return ComponentType.SYMBOL;
    }

    @Override
    public String restore() {
        return String.valueOf(value);
    }

    public char getValue() {
        return value;
    }

    public SymbolType getKind() {
        return kind;
    }
}
