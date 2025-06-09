package com.esdc.composite.composite;

import com.esdc.composite.composite.internal.ComponentType;

import java.util.Collections;
import java.util.List;

/**
 * Root abstraction of the <b>Composite</b> pattern.<br>
 * Enables uniform treatment of every node in the text-tree
 * (both leaves and composite containers).
 */
public interface TextComponent {

    /**
     * Adds a child to the current element.
     * <p>Default implementation treats the element as a <i>leaf</i>
     * and therefore throws {@link UnsupportedOperationException}.
     */
    default void add(TextComponent child) {
        throw new UnsupportedOperationException("Leaf element cannot have children");
    }

    /**
     * Removes a child from the current element.
     * <p>Default implementation is appropriate only for leaves.
     */
    default void remove(TextComponent child) {
        throw new UnsupportedOperationException("Leaf element does not support remove");
    }

    /**
     * Returns an <em>unmodifiable</em> view of children.
     * For leaves this is an empty list.
     */
    default List<TextComponent> getChildren() {
        return Collections.emptyList();
    }

    /**
     * Restores the exact textual fragment represented by this node
     * (including punctuation, white-spaces that belong to the node, etc.).
     */
    String restore();

    /**
     * Logical type of the node (SYMBOL, WORD, SENTENCE, …).
     * May be used by service-layer algorithms for filtering/analysis.
     */
    ComponentType getType();
}
