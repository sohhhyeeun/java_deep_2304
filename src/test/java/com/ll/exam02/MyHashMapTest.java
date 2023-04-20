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
}
