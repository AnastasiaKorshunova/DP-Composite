package com.esdc.task2.parser.impl;

import com.esdc.task2.composite.TextComponent;
import com.esdc.task2.composite.TextComponentType;
import com.esdc.task2.composite.impl.TextComponentLeaf;
import com.esdc.task2.interpreter.ExpressionInterpreter;
import com.esdc.task2.parser.AbstractBaseParser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends AbstractBaseParser {
    private static final String MATH_EXPRESSION = "^[0-9+\\-*/().\\s]{2,}$";
    private static final String BINARY_EXPRESSION = "^(?:\\s*(?:\\d+|<<|>>|[&|^~()])\\s*){2,}$";
    private static final Pattern WORDS_SYMBOLS_PATTERN = Pattern.compile("(\\p{Alnum}+)|(\\P{Alnum})");

    private final ExpressionInterpreter interpreter = new ExpressionInterpreter();

    @Override
    public List<TextComponent> parse(String data) {
        List<TextComponent> textComponents = new ArrayList<>();
        for (String split : data.split(" ")) {
            if (isMathOrBinaryExpression((split.trim()))) {
                int evaluate = interpreter.evaluate(split.replaceAll("", ""));
                split = String.valueOf(evaluate);
            }
            textComponents.add(parseLexeme(split));
        }
        return textComponents;
    }

    private TextComponentLeaf parseLexeme(String data) {
        TextComponentLeaf lexeme = new TextComponentLeaf(TextComponentType.LEXEME);
        Matcher m = WORDS_SYMBOLS_PATTERN.matcher(data);
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

    private TextComponentLeaf parseWord(String data) {
        TextComponentLeaf word = new TextComponentLeaf(TextComponentType.WORD);
        if (getNext() != null) {
            getNext().parse(data).forEach(word::addChild);
        }
        return word;
    }

    private boolean isMathOrBinaryExpression(String lexeme) {
        return lexeme.matches(MATH_EXPRESSION) || lexeme.matches(BINARY_EXPRESSION);
    }
}
