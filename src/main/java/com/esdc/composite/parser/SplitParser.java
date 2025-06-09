package com.esdc.composite.parser;

import com.esdc.composite.composite.TextComponent;

import java.util.function.Supplier;
import java.util.regex.Pattern;

/** Universal handler: split by regex ⇒ delegate parts ⇒ collect into container. */
public abstract class SplitParser<C extends TextComponent>
        extends AbstractBaseParser {

    private final Pattern      splitter;
    private final Supplier<C>  containerFactory;

    SplitParser(String regex, Supplier<C> factory) {
        this.splitter         = Pattern.compile(regex);
        this.containerFactory = factory;
    }

    @Override
    public TextComponent handle(String text) {
        C container = containerFactory.get();
        for (String part : splitter.split(text)) {
            if (!part.isBlank()) container.add(delegate(part.trim()));
        }
        return container;
    }
}
