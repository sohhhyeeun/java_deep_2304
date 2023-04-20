package com.ll.exam01;

import java.util.stream.IntStream;

public class MyArrayList<T> {
    public boolean debug = false;
    private Object[] data;

    private int size = 0;

    public MyArrayList() {
        this(2);
    }

    public MyArrayList(int dataLength) {
        data = new Object[dataLength];
    }

    public int size() {
        return size;
    }

    public boolean add(T element) {
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
        Object[] newData = new String[data.length * 2];

        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }

        if ( debug ) {
            System.out.printf("배열크기 증가 : %d => %d\n", data.length, newData.length);
        }

        data = newData;
    }

    private boolean isNotEnough() {
        return size >= data.length;
    }

    public Object get(int index) {
        return data[index];
    }

    public int indexOf(String element) {
        //배열 객체는 크기 고정
        //배열 내 데이터 수 = size
        for (int i = 0; i < size; i++) {
            if (element.equals(data[i]))
                return i;
        }

        return -1;
    }
}
