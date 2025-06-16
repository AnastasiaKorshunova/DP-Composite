package com.esdc.task2.parser;

import com.esdc.task2.composite.TextComponent;

import java.util.List;

public abstract class AbstractParser {
    private AbstractParser next;

    public AbstractParser linkWith(AbstractParser next) {
        this.next = next;
        return next;
    }

    public abstract List<TextComponent> parse(String data);

    public AbstractParser getNext() {
        return next;
    }
}
