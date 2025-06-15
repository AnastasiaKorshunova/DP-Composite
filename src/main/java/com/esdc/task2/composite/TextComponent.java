package com.esdc.task2.composite;

import java.util.List;

/**
 * Represents a generic component in a text structure using the Composite design pattern.
 * Both composite components (e.g., sentences, paragraphs) and leaf components (e.g., symbols)
 * implement this interface to provide uniform access to operations such as type retrieval,
 * length calculation, component filtering, and recursive removal.
 * <p>
 * This interface does not define structural modification methods (like {@code addComponent}),
 * in order to maintain strict encapsulation and separation of responsibilities.
 */
public interface TextComponent {

    /**
     * Returns the type of this text component.
     *
     * @return the component type (e.g., TEXT, PARAGRAPH, SENTENCE, LEXEME, SYMBOL)
     */
    TextComponentType getType();

    /**
     * Returns the total number of characters represented by this component.
     * For composite components, this is the sum of the lengths of all children.
     *
     * @return the total character count
     */
    int length();

    /**
     * Retrieves all nested components of the specified type from the component hierarchy.
     * For leaf components, this returns an empty list.
     *
     * @param type the type of components to retrieve
     * @return a list of components matching the specified type
     */
    List<TextComponent> getComponents(TextComponentType type);

    /**
     * Attempts to remove the specified component from the hierarchy.
     * This operation is recursive and may remove nested matches in composite structures.
     *
     * @param component the component to remove
     * @return {@code true} if the component was found and removed; {@code false} otherwise
     */
    boolean removeComponent(TextComponent component);
}
