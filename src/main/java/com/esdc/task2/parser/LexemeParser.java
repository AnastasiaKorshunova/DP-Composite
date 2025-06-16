package com.esdc.task2.parser;

import com.esdc.task2.composite.TextComponent;
import com.esdc.task2.composite.impl.Lexeme;
import com.esdc.task2.composite.impl.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends AbstractParser {
    private static final String MATH_EXPRESSION = "^[0-9+\\-*/().\\s]+$";
    private final Pattern wordsSymbolsPattern = Pattern.compile("(\\p{Alnum}+)|(\\P{Alnum})");

    @Override
    public List<TextComponent> parse(String data) {
        List<TextComponent> textComponents = new ArrayList<>();
        String replacedText = data.replaceAll("\n", " ");
        for (String split : replacedText.split(" ")) {
            if (isExpression(data)) {
                continue;
            }
            textComponents.add(parseLexeme(split));
        }
        return textComponents;
    }

    private Lexeme parseLexeme(String data) {
        Lexeme lexeme = new Lexeme();
        Matcher m = wordsSymbolsPattern.matcher(data);
        while (m.find()) {
            if (m.group(1) != null) {
                lexeme.addChild(parseWord(m.group()));
            } else {
                if (getNext() != null) {
                    getNext().parse(m.group()).forEach(lexeme::addChild);
                }
            }
        }
        return lexeme;
    }

    private Word parseWord(String data) {
        Word word = new Word();
        if (getNext() != null) {
            getNext().parse(data).forEach(word::addChild);
        }
        return word;
    }

    private boolean isExpression(String lexeme) {
        return lexeme.matches(MATH_EXPRESSION);
    }
}
