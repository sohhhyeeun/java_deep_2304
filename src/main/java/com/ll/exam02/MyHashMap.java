package com.ll.exam02;

public class MyHashMap<K, V> {
    private int size = 0;
    private Entry[] entries;

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

    public V remove(K key) {
        int index = indexOfKey(key);

        if (index == -1) return null;

        V old = (V) entries[index].value;

        // 앞에서 부터 자리 이동
        for (int i = index + 1; i < size; i++) {
            entries[i - 1] = entries[i];
        }

        size--;

        return old;
    }

    public boolean containsKey(K key) {
        return indexOfKey(key) != -1;
    }

    public boolean containsValue(V value) {
        return indexOfValue(value) != -1;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            entries[i] = null;
        }

        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public V put(K key, V value) {
        // keys 배열에서 검색
        int indexOfKey = indexOfKey(key);

        if (indexOfKey != -1) {
            V old = (V) entries[indexOfKey].value;
            entries[indexOfKey].value = value;
            return old;
        }

        makeNewArrayIfNotEnough();

        entries[size] = new Entry<>(key, value);
        size++;

        return null;
    }

    private void makeNewArrayIfNotEnough() {
        if (isNotEnough()) {
            makeNewArray();
        }
    }

    private void makeNewArray() {
        // 새 배열을 만든다.(새 업체를 만든다.)
        Entry[] newEntries = new Entry[entries.length * 2];

        // 기존 창고에 있던 물품들을 전부 새 창고로 옮긴다.
        for (int i = 0; i < entries.length; i++) {
            newEntries[i] = entries[i];
        }

        // 기존 창고과 계약을 해지한다.
        // 더 이상 리스트가 기존 배열을 가리키지 않도록 하여, 자연스럽게 가비지컬렉팅이 되도록 한다.
        entries = newEntries;
    }

    private boolean isNotEnough() {
        return size >= entries.length;
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

    private int indexOfValue(V value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(entries[i].value)) return i;
        }

        return -1;
    }
}
