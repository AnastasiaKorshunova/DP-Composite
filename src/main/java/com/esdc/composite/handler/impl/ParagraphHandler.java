package com.esdc.composite.handler.impl;


import com.esdc.composite.entity.Paragraph;
import com.esdc.composite.handler.SplitHandler;
import com.esdc.composite.util.RegexConst;

class ParagraphHandler extends SplitHandler<Paragraph> {
    ParagraphHandler() { super(RegexConst.SENTENCE, Paragraph::new); }
    @Override protected com.esdc.composite.entity.Element buildLeaf(String t) { throw new UnsupportedOperationException(); }
}