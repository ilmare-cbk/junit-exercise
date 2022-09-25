package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set 사이즈 확인")
    void test1() {
        Assertions.assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("Set의 contains() 메소드를 활용하여 1,2,3의 값이 존재하는 확인")
    void test2() {
        Assertions.assertThat(numbers.contains(1)).isTrue();
        Assertions.assertThat(numbers.contains(2)).isTrue();
        Assertions.assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set의 contains() 메소드를 활용하여 1,2,3의 값이 존재하는 확인 - ParameterizedTest를 통해 중복제거")
    void test3(int number) {
        Assertions.assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("1, 2, 3 값은 contains()메소드 결과 true, 4, 5는 false 반환")
    void test4(int input, boolean expected) {
        Assertions.assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
