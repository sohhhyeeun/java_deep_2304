package com.ll.exam01;

import com.ll.TestUt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

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

        //현재 배열의 길이 -> 코드를 조금 더 방어적으로 작성하기 위해
        int dataLen1 = ((String[]) TestUt.getFieldValue(list, "data", null)).length;

        // IntStream.range(0, 10); = [0, ... 9] 까지의 int 스트림 발생
        // 딱 1번 넘칠만큼의 데이터
        IntStream.range(0, dataLen1 + 1)
                .forEach(index -> list.add("사과 %d".formatted(index)));

        int dataLen2 = ((String[])TestUt.getFieldValue(list, "data", null)).length;
        assertThat(dataLen2).isGreaterThan(dataLen1);
    }
}
