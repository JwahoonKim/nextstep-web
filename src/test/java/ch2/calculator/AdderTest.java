package ch2.calculator;

import ch2.calculator.Adder;
import ch2.calculator.InputParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class AdderTest {

    private Adder adder;
    private InputParser parser;

    @BeforeEach
    void setUp() {
        parser = new InputParser();
        adder = new Adder(parser);
    }

    @DisplayName("숫자를 더할 수 있다.")
    @Test
    void 숫자_더하기() {
        String input1 = "1,2,3";
        String input2 = "1:2:4";
        String input3 = "//;\n1;2;5";

        int result1 = adder.add(input1);
        int result2 = adder.add(input2);
        int result3 = adder.add(input3);

        assertThat(result1).isEqualTo(6);
        assertThat(result2).isEqualTo(7);
        assertThat(result3).isEqualTo(8);
    }

    @DisplayName("공백이 들어오면 0을 반환한다.")
    @Test
    void 공백이면_0() {
        String input = " ";
        int result = adder.add(input);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자 하나만 들어와도 동작한다.")
    @Test
    void 숫자_하나() {
        String input = "1";
        int result = adder.add(input);
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("null이 들어오면 0을 반환한다.")
    @Test
    void null이면_0() {
        String input = null;
        int result = adder.add(input);
        assertThat(result).isEqualTo(0);
    }

}