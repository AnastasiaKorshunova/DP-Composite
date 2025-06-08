/* ---------- TextHandler.java ---------- */
package com.esdc.task2.handler.impl;

import com.esdc.task2.entity.Text;
import com.esdc.task2.handler.SplitHandler;
import com.esdc.task2.util.RegexConst;

class TextHandler extends SplitHandler<Text> {
    TextHandler() { super(RegexConst.PARAGRAPH, Text::new); }
    @Override protected com.esdc.task2.entity.Element buildLeaf(String t) { throw new UnsupportedOperationException(); }
}
