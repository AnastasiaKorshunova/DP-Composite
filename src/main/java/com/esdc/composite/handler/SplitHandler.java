package com.esdc.composite.handler;

import com.esdc.composite.entity.Element;

import java.util.regex.Pattern;
import java.util.function.Supplier;

/**
 * Универсальный обработчик «режу по regex и делегирую».
 */
abstract class SplitHandler <C extends Element> extends AbstractElementHandler {
    private final Pattern splitter;
    private final Supplier<C> factory;

    SplitHandler(String regex, Supplier<C> factory) {
        this.splitter = Pattern.compile(regex);
        this.factory  = factory;
    }

    @Override public Element handle(String data) {
        C container = factory.get();
        for (String part : splitter.split(data)) {
            if (!part.isBlank()) container.add(delegate(part.trim()));
        }
        return container;
    }
}
