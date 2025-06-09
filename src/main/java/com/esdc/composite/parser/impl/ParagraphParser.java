package com.esdc.composite.parser.impl;

import com.esdc.composite.composite.internal.Paragraph;
import com.esdc.composite.composite.TextComponent;
import com.esdc.composite.parser.SplitParser;
import com.esdc.composite.util.RegexConst;

class ParagraphParser extends SplitParser<Paragraph> {
    ParagraphParser() { super(RegexConst.SENTENCE,
            Paragraph::new); }

    @Override protected TextComponent buildLeaf(String f) { throw new UnsupportedOperationException(); }
}
