package com.skypro.algoritms28_11_22;

import com.skypro.algoritms28_11_22.arraylist.StringListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StringListTest {
    private StringListImpl stringList;

    @BeforeEach
    void setUp() {
        stringList = new StringListImpl(5);
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("a");
    }

    @Test
    public void shouldGetByIndex() {
        assertEquals("a", stringList.get(0));
        assertEquals("b", stringList.get(1));
    }

    @Test
    public void shouldRemoveByItem() {
        stringList.remove("a");
        assertEquals("b", stringList.get(0));
    }

    @Test
    public void shouldRemoveByIndex() {
        stringList.remove(0);
        assertEquals("b", stringList.get(0));
    }

    @Test
    public void shouldReturnFalseWhenCheckEmpty() {
        assertFalse(stringList.isEmpty());
    }

    @Test
    public void shouldReturnFalseWhenCheckContains() {
        assertFalse(stringList.contains("G"));
    }

    @Test
    public void shouldSet() {
        stringList.set(0, "x");
        assertEquals("x", stringList.get(0));
    }

    @Test
    public void shouldGetSize() {
        assertEquals(4, stringList.size());
    }


}
