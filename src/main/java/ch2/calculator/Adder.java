package ch2.calculator;

import java.util.Arrays;

public class Adder {

    private InputParser parser;

    public Adder(InputParser parser) {
        this.parser = parser;
    }


    public int add(String input) {
        int[] numbers = parser.parse(input);
        return Arrays.stream(numbers).sum();
    }
}
