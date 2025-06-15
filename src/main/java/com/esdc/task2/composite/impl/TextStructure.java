package com.esdc.task2.composite.impl;

import com.esdc.task2.composite.TextComponent;
import com.esdc.task2.composite.TextComponentType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * {@code TextStructure} is a composite implementation of the {@link TextComponent} interface.
 * It represents a structured element in a text hierarchy, such as a paragraph, sentence, or lexeme,
 * and can contain other components as children.
 * <p>
 * This class fully encapsulates its internal structure and does not expose direct access to its children,
 * following the principle of strong encapsulation.
 */
public class TextStructure implements TextComponent {

    private final List<TextComponent> children = new ArrayList<>();
    private final TextComponentType type;

    /**
     * Constructs a new {@code TextStructure} with the specified type.
     *
     * @param type the type of this text component (e.g., PARAGRAPH, SENTENCE)
     */
    public TextStructure(TextComponentType type) {
        this.type = type;
    }

    /**
     * Adds a new child component to this composite.
     * <p>
     * This method is intended for building the text structure during parsing or composition.
     *
     * @param child the text component to add
     * @throws NullPointerException if the provided child is {@code null}
     */
    public void addChild(TextComponent child) {
        Objects.requireNonNull(child, "Child component cannot be null");
        children.add(child);
    }

    /**
     * Returns a string representation of the entire composite structure,
     * by concatenating the string representations of all child components.
     *
     * @return the full string representation of this component and its children
     */
    @Override
    public String toString() {
        return children.stream()
                .map(TextComponent::toString)
                .collect(Collectors.joining(""));
    }

    /**
     * Returns the total number of characters represented by this component,
     * including all of its children.
     *
     * @return the total character count
     */
    @Override
    public int length() {
        return children.stream()
                .mapToInt(TextComponent::length)
                .sum();
    }

    /**
     * Returns the type of this text component.
     *
     * @return the component type (e.g., PARAGRAPH, SENTENCE)
     */
    @Override
    public TextComponentType getType() {
        return type;
    }

    /**
     * Recursively collects and returns all subcomponents of the specified type,
     * including nested matches within child components.
     *
     * @param type the desired type of components to extract
     * @return a list of matching components
     */
    @Override
    public List<TextComponent> getComponents(TextComponentType type) {
        return children.stream()
                .flatMap(child -> child.getType().equals(type)
                        ? Stream.of(child)
                        : child.getComponents(type).stream())
                .collect(Collectors.toList());
    }

    /**
     * Recursively searches for and removes the specified component from the hierarchy.
     * The removal is attempted both directly and from all nested children.
     *
     * @param component the component to remove
     * @return {@code true} if the component was found and removed; {@code false} otherwise
     */
    @Override
    public boolean removeComponent(TextComponent component) {
        if (children.remove(component)) {
            return true;
        }
        for (TextComponent child : children) {
            if (child.removeComponent(component)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Compares this component with another for equality.
     * Components are considered equal if their type and child components are equal.
     *
     * @param obj the object to compare to
     * @return {@code true} if equal; {@code false} otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof TextStructure other)) return false;
        return type == other.type && Objects.equals(children, other.children);
    }

    /**
     * Returns a hash code for this component based on its type and children.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(type, children);
    }
}
