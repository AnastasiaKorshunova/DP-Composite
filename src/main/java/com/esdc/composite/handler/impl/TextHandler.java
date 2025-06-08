/* ---------- TextHandler.java ---------- */
package com.esdc.composite.handler.impl;

import com.esdc.composite.entity.Text;
import com.esdc.composite.handler.SplitHandler;
import com.esdc.composite.util.RegexConst;

class TextHandler extends SplitHandler<Text> {
    TextHandler() { super(RegexConst.PARAGRAPH, Text::new); }
    @Override protected com.esdc.composite.entity.Element buildLeaf(String t) { throw new UnsupportedOperationException(); }
}
