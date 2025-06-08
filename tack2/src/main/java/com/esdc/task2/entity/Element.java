// ───────────────── Component.java ─────────────────
package com.esdc.task2.entity;

import java.util.Collections;
import java.util.List;

public abstract class Element {

    /* ===== Composite-API: по умолчанию «лист» ===== */

    public void add(Element child) {
        throw new UnsupportedOperationException("Leaf component can't have children");
    }

    public void remove(Element child) {
        throw new UnsupportedOperationException("Leaf component can't remove children");
    }

    /** У листа детей нет — возвращаем пустой неизменяемый список. */
    public List<Element> getChildren() {
        return Collections.emptyList();
    }

    /* ===== Вспомогательный метод для restore() потомков-контейнеров ===== */

    protected String glueChildren(String delimiter) {
        return getChildren().stream()              // замечание: у листа список пуст
                .map(Element::restore)
                .reduce((a, b) -> a + delimiter + b)
                .orElse("");
    }

    /* ===== Контент-API ===== */

    public abstract ElementType getType();
    public abstract String restore();
}
