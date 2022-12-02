package com.skypro.algoritms28_11_22;

import com.skypro.algoritms28_11_22.arraylist.IntegerListImpl;
import com.skypro.algoritms28_11_22.exception.InvalidIndexException;
import com.skypro.algoritms28_11_22.exception.ListIsFullException;
import com.skypro.algoritms28_11_22.exception.NullItemException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerListTest {
    private IntegerListImpl IntegerList;

    @BeforeEach
    void setUp() {
        IntegerList = new IntegerListImpl(5);
        IntegerList.add(1);
        IntegerList.add(2);
        IntegerList.add(3);
        IntegerList.add(4);
    }

    @Test
    public void shouldContains() {
        assertTrue(IntegerList.contains(1));
        assertTrue(IntegerList.contains(2));
        assertTrue(IntegerList.contains(3));
        assertTrue(IntegerList.contains(4));
        assertFalse(IntegerList.contains(5));
    }

//    @Test
//    public void shouldGetByIndex() {
//        assertEquals("a", IntegerList.get(0));
//        assertEquals("b", IntegerList.get(1));
//        assertEquals("a", IntegerList.get(3));
//
//    }
//
//    @Test
//    public void shouldRemoveByItem() {
//        IntegerList.remove("a");
//        assertEquals("b", IntegerList.get(0));
//        assertEquals("c", IntegerList.get(1));
//        assertEquals("a", IntegerList.get(2));
//        assertEquals(3, IntegerList.size());
//    }
//
//    @Test
//    public void shouldRemoveByIndex() {
//        IntegerList.remove(0);
//        assertEquals("b", IntegerList.get(0));
//    }
//
//    @Test
//    public void shouldReturnFalseWhenCheckEmpty() {
//        assertFalse(IntegerList.isEmpty());
//    }
//
//    @Test
//    public void shouldReturnFalseWhenCheckContains() {
//        assertFalse(IntegerList.contains("G"));
//    }
//
//    @Test
//    public void shouldSet() {
//        IntegerList.set(0, "x");
//        assertEquals("x", IntegerList.get(0));
//    }
//
//    @Test
//    public void shouldGetSize() {
//        assertEquals(4, IntegerList.size());
//    }
//
//    @Test
//    public void shouldAddItemByIndex() {
//        IntegerList.add(3, "X");
//        assertEquals("X", IntegerList.get(3));
//        assertEquals(5, IntegerList.size());
//        assertEquals("a", IntegerList.get(4));
//    }
//
//    @Test
//    public void shouldAddItemByIndex2() {
//        IntegerList.add(4, "X");
//        assertEquals("X", IntegerList.get(4));
//        assertEquals(5, IntegerList.size());
//        assertEquals("a", IntegerList.get(3));
//    }
//
//    @Test
//    public void shouldReturnIndexOf() {
//        assertEquals(0, IntegerList.indexOf("a"));
//    }
//
//    @Test
//    public void shouldReturnIndexOfLast() {
//        assertEquals(3, IntegerList.lastIndexOf("a"));
//    }
//
//    @Test
//    public void shouldThrowIndexExceptionWhenGet() {
//        assertThrows(InvalidIndexException.class, () -> IntegerList.get(5));
//    }
//
//    @Test
//    public void shouldThrowIndexExceptionWhenRemove() {
//        assertThrows(InvalidIndexException.class, () -> IntegerList.remove(4));
//        assertThrows(InvalidIndexException.class, () -> IntegerList.remove("W"));
//    }
//
//    @Test
//    public void shouldThrowIndexExceptionWhenAddByIndex() {
//        assertThrows(InvalidIndexException.class, () -> IntegerList.add(6, "W"));
//    }
//
//    @Test
//    public void shouldThrowItemExceptionWhenAdd() {
//        assertThrows(NullItemException.class, () -> IntegerList.add(null));
//    }
//
//    @Test
//    public void shouldThrowItemExceptionWhenEquals() {
//        assertThrows(NullItemException.class, () -> IntegerList.equals(null));
//    }
//
//    @Test
//    public void shouldThrowItemExceptionWhenSet() {
//        assertThrows(NullItemException.class, () -> IntegerList.set(1, null));
//    }
//
//    @Test
//    public void shouldThrowListFullExceptionWhenLengthEqualsSize() {
//        assertThrows(ListIsFullException.class, () -> IntegerList.add(2, "2"));
//    }
}
