package com.esdc.task2.interpreter;

import java.util.Set;

import static java.lang.Character.isDigit;

public class Lexer {
    private static final String SINGLE_CHAR_OPERATOR = "+-*/&|^~";
    private static final Set<String> OPERANDS = Set.of(">>", "<<", "++", "--");
    private final String source;
    private int index = 0;

    Lexer(String s) {
        source = s;
    }

    Token next() {
        while (index < source.length() && Character.isWhitespace(source.charAt(index))) index++;
        if (index >= source.length()) return new Token(Kind.EOF, "");
        char c = source.charAt(index);

        if (isDigit(c)) {                       // number
            int start = index;
            while (index < source.length() && isDigit(source.charAt(index))) index++;
            return new Token(Kind.NUMBER, source.substring(start, index));
        }
        if (c == '(' || c == ')') {             // parentheses
            index++;
            return new Token(c == '(' ? Kind.LPARENTHESIS : Kind.RPARENTHESIS, Character.toString(c));
        }
        if (index + 1 < source.length()) {
            String two = source.substring(index, index + 2);
            if (OPERANDS.contains(two)) {
                index += 2;
                return new Token(Kind.OPERATION, two);
            }
        }
        if (SINGLE_CHAR_OPERATOR.indexOf(c) >= 0) {
            index++;
            return new Token(Kind.OPERATION, Character.toString(c));
        }

        throw new RuntimeException("Illegal character: " + c);
    }
}
