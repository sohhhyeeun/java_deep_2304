package com.ll.exam01;

public class MyArrayList<T> {
    private String[] data = new String[100];
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean add(String element) {
        //공간이 부족하면 새로운 data 객체 생성
        makeNewDataIfNotEnough();
        data[size] = element;
        size++;

        return true;
    }

    private void makeNewDataIfNotEnough() {
        if (isNotEnough()) {
            makeNewData();
        }
    }

    private void makeNewData() {
        String[] newData = new String[data.length * 2];

        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }

    private boolean isNotEnough() {
        return size >= data.length;
    }

    public String get(int index) {
        return data[index];
    }
}
