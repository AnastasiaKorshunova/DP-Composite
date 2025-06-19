package com.esdc.task2.comparator;

import com.esdc.task2.composite.TextComponent;

import java.util.Comparator;

public class SentenceCountComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent textComponent1, TextComponent textComponent2) {
        int sentences1 = textComponent1.getChildren().size();
        int sentences2 = textComponent2.getChildren().size();
        return Integer.compare(sentences1, sentences2);
    }
}
