package com.skypro.algoritms28_11_22;

import com.skypro.algoritms28_11_22.arraylist.StringListImpl;
import com.skypro.algoritms28_11_22.exception.InvalidIndexException;
import com.skypro.algoritms28_11_22.exception.ListIsFullException;
import com.skypro.algoritms28_11_22.exception.NullItemException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals("a", stringList.get(3));

    }

    @Test
    public void shouldRemoveByItem() {
        stringList.remove("a");
        assertEquals("b", stringList.get(0));
        assertEquals("c", stringList.get(1));
        assertEquals("a", stringList.get(2));
        assertEquals(3, stringList.size());
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

    @Test
    public void shouldAddItemByIndex() {
        stringList.add(3, "X");
        assertEquals("X", stringList.get(3));
        assertEquals(5, stringList.size());
        assertEquals("a", stringList.get(4));
    }

    @Test
    public void shouldAddItemByIndex2() {
        stringList.add(4, "X");
        assertEquals("X", stringList.get(4));
        assertEquals(5, stringList.size());
        assertEquals("a", stringList.get(3));
    }

    @Test
    public void shouldReturnIndexOf() {
        assertEquals(0, stringList.indexOf("a"));
    }

    @Test
    public void shouldReturnIndexOfLast() {
        assertEquals(3, stringList.lastIndexOf("a"));
    }

    @Test
    public void shouldThrowIndexExceptionWhenGet() {
        assertThrows(InvalidIndexException.class, () -> stringList.get(5));
    }

    @Test
    public void shouldThrowIndexExceptionWhenRemove() {
        assertThrows(InvalidIndexException.class, () -> stringList.remove(4));
        assertThrows(InvalidIndexException.class, () -> stringList.remove("W"));
    }

    @Test
    public void shouldThrowIndexExceptionWhenAddByIndex() {
        assertThrows(InvalidIndexException.class, () -> stringList.add(6, "W"));
    }

    @Test
    public void shouldThrowItemExceptionWhenAdd() {
        assertThrows(NullItemException.class, () -> stringList.add(null));
    }

    @Test
    public void shouldThrowItemExceptionWhenEquals() {
        assertThrows(NullItemException.class, () -> stringList.equals(null));
    }

    @Test
    public void shouldThrowItemExceptionWhenSet() {
        assertThrows(NullItemException.class, () -> stringList.set(1, null));
    }

    @Test
    public void shouldThrowListFullExceptionWhenLengthEqualsSize() {
        assertThrows(ListIsFullException.class, () -> stringList.add(2, "2"));
    }
}
