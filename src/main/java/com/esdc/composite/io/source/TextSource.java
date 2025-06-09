package com.esdc.composite.io.source;

/** Strategy for providing raw text to the parser. */
@FunctionalInterface
public interface TextSource {
    String load() throws Exception;
}
