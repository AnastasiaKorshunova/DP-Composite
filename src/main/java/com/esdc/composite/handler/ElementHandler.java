package com.esdc.composite.handler;

import com.esdc.composite.entity.Element;

/**
 * Контракт звена в Chain‑of‑Responsibility: обрабатывает строку,
 * создаёт {@link Element} и, при необходимости, делегирует дальше.
 */
public interface ElementHandler {
    Element handle(String data);
    void setNext(ElementHandler next);
}
