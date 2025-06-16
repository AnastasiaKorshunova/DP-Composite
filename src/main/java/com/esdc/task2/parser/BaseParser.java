package com.esdc.task2.parser;

import com.esdc.task2.composite.TextComponent;

import java.util.List;

public interface BaseParser {

    BaseParser linkWith(BaseParser next);

    List<TextComponent> parse(String data);

    BaseParser getNext();
}
