package com.skypro.algoritms28_11_22.arraylist;

import com.skypro.algoritms28_11_22.exception.InvalidIndexException;
import com.skypro.algoritms28_11_22.exception.ListIsFullException;
import com.skypro.algoritms28_11_22.exception.NullItemException;
import com.sun.jdi.InvalidCodeIndexException;

import java.util.ArrayList;
import java.util.Arrays;

public class StringListImpl implements StringList {
    private final String[] arrayList;
    private int size;

    public StringListImpl() {
        arrayList = new String[10];
    }

    public StringListImpl(int initialSize) {
        arrayList = new String[initialSize];
    }

    @Override
    public String add(String item) {
        validateSize();
        validateItem(item);
        arrayList[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateSize();
        if (index > arrayList.length) {
            throw new InvalidIndexException();
        }

        if (index == size) {
            arrayList[size++] = item;
        } else {
            System.arraycopy(arrayList, index, arrayList, index + 1, size  - index);
            arrayList[index] = item;
            size++;
        }
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        arrayList[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        return remove(indexOf(item));
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        if (index == size - 1) {
            arrayList[index] = null;
        } else {
            System.arraycopy(arrayList, index + 1, arrayList, index, size -1 - index);
        }

        size--;
        return arrayList[index];
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (arrayList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (arrayList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return arrayList[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new NullItemException("Передан null");
        }
        return Arrays.equals(arrayList, otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;

    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(arrayList, size);
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new InvalidIndexException();
        }
    }

    private void validateItem(String item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private void validateSize() {
        if (size == arrayList.length) {
            throw new ListIsFullException();
        }

    }
}
