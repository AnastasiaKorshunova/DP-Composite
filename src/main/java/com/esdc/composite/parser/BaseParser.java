package com.esdc.composite.parser;

import com.esdc.composite.composite.TextComponent;

/**
 * One handler of the Chain-of-Responsibility.
 * <p>Receives a raw string, converts it to a {@link TextComponent}
 * and, when necessary, delegates further down the chain.</p>
 */
public interface BaseParser {

   /** Splits / converts the incoming fragment and returns the node. */
   TextComponent handle(String text);

   /** Connects the next handler in the chain. */
   void setNext(BaseParser next);
}