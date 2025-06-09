package com.esdc.composite.parser.impl;

import com.esdc.composite.composite.*;
import com.esdc.composite.composite.internal.Lexeme;
import com.esdc.composite.composite.internal.Symbol;
import com.esdc.composite.composite.internal.type.SymbolType;
import com.esdc.composite.interpreter.ExpressionInterpreter;
import com.esdc.composite.parser.AbstractBaseParser;
import com.esdc.composite.util.RegexConst;

class LexemeParser extends AbstractBaseParser {

    @Override
    public TextComponent handle(String fragment) {
        // 1) arithmetic lexeme?
        if (fragment.matches(RegexConst.ARITHMETIC)) {
            double val = new ExpressionInterpreter().evaluate(fragment);
            Lexeme lex = new Lexeme();
            for (char ch : String.valueOf(val).toCharArray()) {
                lex.add(new Symbol(ch,
                        Character.isDigit(ch) ? SymbolType.NUMBER : SymbolType.PUNCTUATION));
            }
            return lex;
        }
        // 2) otherwise → delegate to SymbolParser
        return delegate(fragment);
    }

    @Override protected TextComponent buildLeaf(String f) {
        throw new UnsupportedOperationException("LexemeParser delegates to SymbolParser");
    }
}
