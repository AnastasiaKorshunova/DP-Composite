package com.esdc.task2.composite.impl;

import com.esdc.task2.composite.TextComponent;
import com.esdc.task2.composite.TextComponentType;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * {@code Symbol} is a leaf implementation of the {@link TextComponent} interface.
 * It represents a single character in the text structure and cannot contain any child components.
 * <p>
 * This class is immutable and fully encapsulated.
 */
public class Symbol implements TextComponent {

    private final char character;
    private final TextComponentType type = TextComponentType.SYMBOL;

    /**
     * Constructs a new {@code Symbol} with the specified character.
     *
     * @param character the character this symbol represents
     */
    public Symbol(char character) {
        this.character = character;
    }

    /**
     * Returns the character represented by this symbol.
     *
     * @return the character
     */
    public char getCharacter() {
        return character;
    }

    /**
     * Returns the string representation of this symbol (a single character).
     *
     * @return the character as a string
     */
    @Override
    public String toString() {
        return String.valueOf(character);
    }

    /**
     * Returns the type of this component, which is always {@code SYMBOL}.
     *
     * @return the component type
     */
    @Override
    public TextComponentType getType() {
        return type;
    }

    /**
     * Returns the length of this symbol, which is always 1.
     *
     * @return 1
     */
    @Override
    public int length() {
        return 1;
    }

    /**
     * Returns an empty list since a symbol cannot contain any children.
     *
     * @param type the desired type of components (ignored)
     * @return an empty list
     */
    @Override
    public List<TextComponent> getComponents(TextComponentType type) {
        return Collections.emptyList();
    }

    /**
     * A symbol cannot contain children, so this always returns {@code false}.
     *
     * @param component the component to remove (ignored)
     * @return {@code false}
     */
    @Override
    public boolean removeComponent(TextComponent component) {
        return false;
    }

    /**
     * Compares this symbol with another for equality.
     * Symbols are equal if they represent the same character.
     *
     * @param obj the object to compare to
     * @return {@code true} if equal; {@code false} otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Symbol other)) return false;
        return character == other.character;
    }

    /**
     * Returns a hash code for this symbol based on its character.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(character);
    }
}

