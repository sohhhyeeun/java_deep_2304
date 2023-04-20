package com.ll.exam02;

public class MyHashMap<K, V> {
    private int size = 0;
    private final Entry[] entries;

    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        this(2);
    }

    public MyHashMap(int arrayLength) {
        entries = new Entry[arrayLength];
    }

    public int size() {
        return size;
    }

    public V put(K key, V value) {
        entries[size] = new Entry<>(key, value);

        size++;

        return null;
    }

    public V get(K key) {
        // keys 배열에서 검색
        int indexOfKey = indexOfKey(key);

        // 만약에 못 찾으면 null 리턴
        if (indexOfKey == -1) return null;

        // 만약에 찾으면 해당 인덱스를 가지고 values 배열에 접근 해서 리턴
        return (V) entries[indexOfKey].value;
    }

    private int indexOfKey(K key) {
        for (int i = 0; i < size; i++) {
            if (key.equals(entries[i].key))
                return i;
        }

        return -1;
    }
}
