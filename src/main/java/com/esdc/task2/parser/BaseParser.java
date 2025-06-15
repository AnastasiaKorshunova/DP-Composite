package com.esdc.task2.parser;

import com.esdc.task2.chain.ChainHandler;
import com.esdc.task2.composite.TextComponent;

/**
 * Represents a single parser in the Chain of Responsibility.
 * <p>
 * Each parser receives a raw string, processes or splits it into a {@link TextComponent},
 * and optionally delegates further processing to the next parser in the chain.
 * </p>
 */
public interface BaseParser extends ChainHandler<BaseParser> {

    /**
     * Processes the given text and returns a corresponding {@link TextComponent}.
     * The implementation may delegate part of the processing to the next parser in the chain.
     *
     * @param text the raw string to parse
     * @return a parsed text component
     */
    TextComponent handle(String text);

    /**
     * Sets the next parser in the chain.
     *
     * @param next the next parser to be called after this one
     */
    @Override
    void setNext(BaseParser next);
}
