package com.esdc.composite.parser;

import com.esdc.composite.composite.TextComponent;

/** Common delegating logic for all concrete parsers. */
public abstract class AbstractBaseParser implements BaseParser {

    private BaseParser next;

    @Override
    public final void setNext(BaseParser next) {
        this.next = next;
    }

    /**
     * Delegates the fragment to the next parser or creates a leaf
     * if the chain ends here.
     */
    protected TextComponent delegate(String fragment) {
        return (next == null) ? buildLeaf(fragment) : next.handle(fragment);
    }

    @Override public abstract TextComponent handle(String text);
    protected abstract TextComponent buildLeaf(String fragment);

    AbstractBaseParser next(AbstractBaseParser n) { setNext(n); return n; }
}
