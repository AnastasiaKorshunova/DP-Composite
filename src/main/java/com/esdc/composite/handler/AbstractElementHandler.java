package com.esdc.composite.handler;

import com.esdc.composite.entity.Element;

/** Базовый обработчик со ссылкой «next» и общим методом delegate(). */
abstract class AbstractElementHandler implements ElementHandler {
    private ElementHandler next;

    @Override public final void setNext(ElementHandler next) { this.next = next; }

    /** Либо обрабатываем сами, либо передаём дальше. */
    protected Element delegate(String part) {
        return (next == null) ? buildLeaf(part) : next.handle(part);
    }

    /** Fluent‑builder для сборки цепочки. */
    AbstractElementHandler next(AbstractElementHandler n) { setNext(n); return n; }

    @Override public abstract Element handle(String data);
    protected abstract Element buildLeaf(String token);
}