package com.esdc.composite.parser.impl;

import com.esdc.composite.composite.internal.Sentence;
import com.esdc.composite.composite.TextComponent;
import com.esdc.composite.parser.SplitParser;
import com.esdc.composite.util.RegexConst;

class SentenceParser extends SplitParser<Sentence> {
    SentenceParser() { super(RegexConst.LEXEME,
            Sentence::new); }

    @Override protected TextComponent buildLeaf(String f) { throw new UnsupportedOperationException(); }
}
