package com.esdc.task2.handler.impl;


import com.esdc.task2.entity.Paragraph;
import com.esdc.task2.handler.SplitHandler;
import com.esdc.task2.util.RegexConst;

class ParagraphHandler extends SplitHandler<Paragraph> {
    ParagraphHandler() { super(RegexConst.SENTENCE, Paragraph::new); }
    @Override protected com.esdc.task2.entity.Element buildLeaf(String t) { throw new UnsupportedOperationException(); }
}