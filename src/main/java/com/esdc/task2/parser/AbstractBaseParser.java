package com.esdc.task2.parser;

import com.esdc.task2.composite.TextComponent;

import java.util.List;

public abstract class AbstractBaseParser {
    AbstractBaseParser nextParser;

    public AbstractBaseParser linkWith(AbstractBaseParser next) {
        this.nextParser = next;
        return nextParser;
    }

    public abstract List<TextComponent> parse(String data);

    public AbstractBaseParser getNext() {
        return nextParser;
    }
}
