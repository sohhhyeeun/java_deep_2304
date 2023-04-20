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

    @Test
    @DisplayName("MyArrayList 초기화(new)시 생성자 인자로 data 배열의 사이즈 지정")
    void t05() {
        MyArrayList<String> list = new MyArrayList<>(200);

        // 초기 배열의 길이
        int dataLength = ((String[]) TestUt.getFieldValue(list, "data", null)).length;

        assertThat(dataLength).isEqualTo(200);
    }

    @Test
    @DisplayName("디버그(출력을 위한) : 데이터를 많이 넣으면 배열증가가 많이 발생함")
    void t06() {
        MyArrayList<String> list = new MyArrayList<>();
        list.debug = true;

        // IntStream.range(0, 10); = [0, ... 9] 까지의 int 스트림 발생
        // 딱 1번 넘칠만큼의 데이터
        IntStream.range(0, 100)
                .forEach(index -> list.add("사과 %d".formatted(index)));
    }

    @Test
    @DisplayName("디버그 : 애초에 큰 배열로 만들어 데이터를 많이 넣어도 배열 증가가 빈번하게 일어나지 않도록 수정")
    void t07() {
        MyArrayList<String> list = new MyArrayList<>(25);
        list.debug = true;

        // IntStream.range(0, 10); = [0, ... 9] 까지의 int 스트림 발생
        // 딱 1번 넘칠만큼의 데이터
        IntStream.range(0, 100)
                .forEach(index -> list.add("사과 %d".formatted(index)));
    }

    @Test
    @DisplayName("indexOf")
    void t08() {
        MyArrayList<String> list = new MyArrayList<>(25);

        IntStream.range(0, 100)
                .forEach(index -> list.add("사과 %d".formatted(index)));

        assertThat(list.indexOf("사과 0")).isEqualTo(0);
        assertThat(list.indexOf("사과 1")).isEqualTo(1);
        assertThat(list.indexOf("사과 100")).isEqualTo(-1);
    }
}
