package com.skypro.algoritms28_11_22.arraylist;

import com.skypro.algoritms28_11_22.exception.InvalidIndexException;
import com.skypro.algoritms28_11_22.exception.ListIsFullException;
import com.skypro.algoritms28_11_22.exception.NullItemException;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {
    private Integer[] arrayList;
    private int size;

    public IntegerListImpl() {
        arrayList = new Integer[10];
    }

    public IntegerListImpl(int initialSize) {
        arrayList = new Integer[initialSize];
    }

    @Override
    public Integer add(Integer item) {
        validateSize();
        validateItem(item);
        arrayList[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
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
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        arrayList[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        return remove(indexOf(item));
    }

    @Override
    public Integer remove(int index) {
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
    public boolean contains(Integer item) {
        Integer[] copyList = toArray();
        sort(copyList);
        return binarySearch(copyList, item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (arrayList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (arrayList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return arrayList[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
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
    public Integer[] toArray() {
        return Arrays.copyOf(arrayList, size);
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new InvalidIndexException();
        }
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private void validateSize() {
        if (size == arrayList.length) {
            grow();
        }
    }

    private void sort(Integer[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static boolean binarySearch(Integer[] arr, int element) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == arr[mid]) {
                return true;
            }

            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    private void grow() {
        arrayList = Arrays.copyOf(arrayList, size + size / 2);
    }

    private static void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private static void swapElements(Integer[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
