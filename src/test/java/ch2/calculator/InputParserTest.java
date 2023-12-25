package ch2.calculator;

import ch2.calculator.InputParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputParserTest {

    private InputParser parser;

    @BeforeEach
    void setUp() {
        parser = new InputParser();
    }

    @DisplayName("쉼표로 구분할 수 있다.")
    @Test
    void 쉼표로_구분() {
        String input = "1,2,3";
        int[] result = parser.parse(input);
        assertThat(result).containsExactly(1, 2, 3);
    }

    @DisplayName("콜론으로 구분할 수 있다.")
    @Test
    void 콜론으로_구분() {
        String input = "1:2:3";
        int[] result = parser.parse(input);
        assertThat(result).containsExactly(1, 2, 3);
    }

    @DisplayName("커스텀한 구분자를 이용할 수 있다.")
    @Test
    void 커스텀_구분자() {
        String input = "//;\n1;2;3";
        int[] result = parser.parse(input);
        assertThat(result).containsExactly(1, 2, 3);
    }

    @DisplayName("공백이 들어오면 빈 배열을 반환한다.")
    @Test
    void 공백() {
        String input = " ";
        int[] result = parser.parse(input);
        assertThat(result).isEmpty();
    }

    @DisplayName("음수가 들어오면 예외를 발생시킨다.")
    @Test
    void 음수_예외() {
        String input = "1,2,3,-4";
        Assertions.assertThrows(RuntimeException.class, () -> {
            parser.parse(input);
        });
    }
}