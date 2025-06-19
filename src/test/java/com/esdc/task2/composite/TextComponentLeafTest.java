package com.esdc.task2.composite;

import com.esdc.task2.composite.impl.TextComponentLeaf;
import com.esdc.task2.composite.impl.TextComponentSymbol;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TextComponentLeafTest {
    @Test
    void getTypeShouldReturnConstructorType() {
        TextComponentLeaf leaf = new TextComponentLeaf(TextComponentType.WORD);
        assertEquals(TextComponentType.WORD, leaf.getType());
    }

    @Test
    void toStringShouldBeEmptyWhenNoChildren() {
        TextComponentLeaf leaf = new TextComponentLeaf(TextComponentType.WORD);
        assertEquals("", leaf.toString());
    }

    @Test
    void addChildAndGetChildrenShouldReflectAdds() {
        TextComponentLeaf leaf = new TextComponentLeaf(TextComponentType.WORD);
        TextComponentSymbol a = new TextComponentSymbol('a');
        TextComponentSymbol b = new TextComponentSymbol('b');
        leaf.addChild(a);
        leaf.addChild(b);
        List<TextComponent> children = leaf.getChildren();
        assertEquals(2, children.size());
        assertSame(a, children.get(0));
        assertSame(b, children.get(1));
    }

    @Test
    void toStringShouldConcatenateWithDelimiter() {
        TextComponentLeaf leaf = new TextComponentLeaf(TextComponentType.PARAGRAPH);
        TextComponentSymbol a = new TextComponentSymbol('a');
        TextComponentSymbol b = new TextComponentSymbol('b');
        leaf.addChild(a);
        leaf.addChild(b);
        assertEquals("a b", leaf.toString());
    }

    @Test
    void removeComponentShouldRemoveExistingAndReturnTrue() {
        TextComponentLeaf leaf = new TextComponentLeaf(TextComponentType.WORD);
        TextComponentSymbol x = new TextComponentSymbol('x');
        leaf.addChild(x);
        assertTrue(leaf.removeComponent(x));
        assertTrue(leaf.getChildren().isEmpty());
    }

    @Test
    void removeComponentShouldReturnFalseWhenNotPresent() {
        TextComponentLeaf leaf = new TextComponentLeaf(TextComponentType.WORD);
        TextComponentSymbol y = new TextComponentSymbol('y');
        assertFalse(leaf.removeComponent(y));
    }
}
