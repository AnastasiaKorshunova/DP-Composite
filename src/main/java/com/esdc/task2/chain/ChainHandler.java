package com.esdc.task2.chain;

/**
 * Represents a generic element in a chain of responsibility.
 *
 * @param <T> the type that extends this interface
 */
public interface ChainHandler<T extends ChainHandler<T>> {

    /**
     * Sets the next handler in the chain.
     *
     * @param handler the next handler
     */
    void setNext(T handler);

    /**
     * Links a sequence of handlers into a chain by setting each handler's next element.
     *
     * @param first the first handler in the chain
     * @param handlers the remaining handlers to be linked
     * @return the head of the chain (the first handler)
     */
    @SafeVarargs
    static <T extends ChainHandler<T>> T link(T first, T... handlers) {
        T current = first;
        for (T handler : handlers) {
            current.setNext(handler);
            current = handler;
        }
        return first;
    }
}
