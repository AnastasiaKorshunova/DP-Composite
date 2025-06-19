package com.esdc.task2.composite;

import java.util.List;

public interface TextComponent {

    TextComponentType getType();

    boolean removeComponent(TextComponent component);

    void addChild(TextComponent component);

    List<TextComponent> getChildren();
}
