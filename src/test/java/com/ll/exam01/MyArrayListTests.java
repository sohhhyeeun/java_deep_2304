package com.ll.exam01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyArrayListTests {
    @Test
    @DisplayName("size()")
    void t01() {
        MyArrayList<String> list = new MyArrayList<>();
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("add(\"사과\")")
    void t02() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("사과");
        list.add("복숭아");

        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("get(1)")
    void t03() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("사과");
        list.add("복숭아");

        assertThat(list.get(0)).isEqualTo("사과");
        assertThat(list.get(1)).isEqualTo("복숭아");
    }

    @Test
    @DisplayName("data 배열 크기 자동 조정")
    void t04() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("사과");
        list.add("복숭아");
        list.add("블루베리");

        assertThat(list.size()).isEqualTo(3);
    }
}
