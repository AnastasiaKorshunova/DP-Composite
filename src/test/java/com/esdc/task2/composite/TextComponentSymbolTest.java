package com.esdc.task2.composite;

import com.esdc.task2.composite.impl.TextComponentSymbol;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TextComponentSymbolTest {
    @Test
    void getTypeShouldReturnSymbol() {
        TextComponentSymbol symbol = new TextComponentSymbol('x');
        assertEquals(TextComponentType.SYMBOL, symbol.getType());
    }

    @Test
    void toStringShouldReturnCharacter() {
        TextComponentSymbol symbol = new TextComponentSymbol('Z');
        assertEquals("Z", symbol.toString());
    }

    @Test
    void removeComponentShouldThrow() {
        TextComponentSymbol symbol = new TextComponentSymbol('a');
        UnsupportedOperationException ex = assertThrows(
                UnsupportedOperationException.class,
                () -> symbol.removeComponent(null)
        );
        assertTrue(ex.getMessage().contains("Cannot remove symbol element"));
    }

    @Test
    void addChildShouldThrow() {
        TextComponentSymbol symbol = new TextComponentSymbol('a');
        UnsupportedOperationException ex = assertThrows(
                UnsupportedOperationException.class,
                () -> symbol.addChild(symbol)
        );
        assertTrue(ex.getMessage().contains("Cannot add child to the symbol element"));
    }

    @Test
    void getChildrenShouldThrow() {
        TextComponentSymbol symbol = new TextComponentSymbol('a');
        UnsupportedOperationException ex = assertThrows(
                UnsupportedOperationException.class,
                symbol::getChildren
        );
        assertTrue(ex.getMessage().contains("Cannot get children of the symbol element"));
    }
}
