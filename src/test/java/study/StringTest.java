package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("'1,2'를 ','로 split 했을 때 1,2로 잘 분리되는지 확인")
    void test1() {
        String str = "1,2";
        String[] results = str.split(",");
        Assertions.assertThat(results).contains("1", "2");
    }

    @Test
    @DisplayName("'1'를 ','로 split 했을 때 1만 포함하는 배열이 반환되는지 확인")
    void test2() {
        String str = "1";
        String[] results = str.split(",");
        Assertions.assertThat(results).containsExactly("1");
    }

    @Test
    @DisplayName("'(1,2)'값이 주어졌을 때 String의 substring() 메소드를 활용해 '()'를 제거하고 '1,2'를 반환")
    void test3() {
        String str = "(1,2)";
        String result = str.substring(1, 4);
        Assertions.assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("'abc'값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오기")
    void test4() {
        String str = "abc";
        char result = str.charAt(2);
        Assertions.assertThat(result).isEqualTo('c');
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException 발생")
    void test5() {
        String str = "abc";
        Assertions.assertThatThrownBy(() -> str.charAt(3))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
