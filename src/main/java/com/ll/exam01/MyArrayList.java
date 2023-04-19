package com.ll.exam01;

public class MyArrayList<T> {
    private String[] data = new String[2];
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean add(String element) {
        data[size] = element;

        size++;
        return true;
    }

    public String get(int index) {
        return data[index];
    }
}
