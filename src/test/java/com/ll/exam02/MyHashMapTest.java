package com.ll.exam02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class MyHashMapTest {
    @Test
    @DisplayName("size()")
    void t01() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        assertThat(map.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("put 구현")
    void t02() {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        assertThat(map.put("철수", 22)).isNull();
        assertThat(map.put("영희", 23)).isNull();

        assertThat(map.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("get 구현")
    void t03() {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        map.put("철수", 22);
        map.put("영희", 23);

        int age1 = map.get("철수");
        int age2 = map.get("영희");

        assertThat(age1).isEqualTo(22);
        assertThat(age2).isEqualTo(23);
    }

    @Test
    @DisplayName("배열 크기 자동 증가")
    void t04() {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        map.put("철수", 22);
        map.put("영희", 23);
        map.put("영수", 23);
    }

    @Test
    @DisplayName("put, replace")
    void t05() {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        map.put("철수", 22);
        map.put("영희", 23);

        assertThat(
                map.put("영희", 24)
        ).isEqualTo(23);

        assertThat(map.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("remove")
    void t06() {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        map.put("철수", 22);
        map.put("영희", 23);

        assertThat(
                map.remove("영희")
        ).isEqualTo(23);

        assertThat(
                map.remove("영숙")
        ).isEqualTo(null);

        assertThat(map.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("containsKey")
    void t07() {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        map.put("철수", 22);
        map.put("영희", 23);

        assertThat(
                map.containsKey("영희")
        ).isTrue();

        assertThat(
                map.containsKey("영숙")
        ).isFalse();
    }

    @Test
    @DisplayName("containsValue")
    void t08() {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        map.put("철수", 22);
        map.put("영희", 23);

        assertThat(
                map.containsValue(22)
        ).isTrue();

        assertThat(
                map.containsValue(24)
        ).isFalse();
    }

    @Test
    @DisplayName("clear")
    void t09() {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        map.put("철수", 22);
        map.put("영희", 23);
        map.clear();

        assertThat(map.size()).isEqualTo(0);
        assertThat(map.isEmpty()).isTrue();
    }
}
