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
        // 만약에 공간이 부족하면 새 data 객체를 만든다.
        makeNewDataIfNotEnough();
        data[size] = element;

        size++;

        return true;
    }

    public boolean add(int index, T element) {
        // 만약에 공간이 부족하면 새 data 객체를 만든다.
        makeNewDataIfNotEnough();

        // 해당 공간을 빈공간으로 만든다.
        makeEmptyIndex(index);

        data[index] = element;

        size++;

        return true;
    }

    public T set(int index, T element) {
        T old = (T) data[index];

        data[index] = element;

        return old;
    }

    public T remove(int index) {
        T old = (T) data[index];

        // 앞에서 부터 자리 이동
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }

        size--;

        return old;
    }

    private void makeEmptyIndex(int index) {
        // 맨뒤 승객부터 뒤로 1칸씩 이동

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
    }

    private void makeNewDataIfNotEnough() {
        if (isNotEnough()) {
            makeNewData();
        }
    }

    private void makeNewData() {
        Object[] newData = new Object[data.length * 2];

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

    public T get(int index) {
        return (T) data[index];
    }

    public int indexOf(T element) {
        //배열 객체는 크기 고정
        //배열 내 데이터 수 = size
//        for (int i = 0; i < size; i++) {
//            if (element.equals(data[i]))
//                return i;
//        }
//
//        return -1;

        return IntStream.range(0, size)
                .filter(index -> element.equals(data[index]))
                .findFirst()
                .orElse(-1);
    }

    public boolean contains(T element) {
        return indexOf(element) != -1;
    }
}
