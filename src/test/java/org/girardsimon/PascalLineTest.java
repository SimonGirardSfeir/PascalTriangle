package org.girardsimon;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PascalLineTest {

    private static Stream<Arguments> inputsNextLine() {
        return Stream.of(
                Arguments.of(new PascalLine(Collections.singletonList(1L)), new PascalLine(List.of(1L,1L))),
                Arguments.of(new PascalLine(List.of(1L,1L)), new PascalLine(List.of(1L,2L,1L))),
                Arguments.of(new PascalLine(List.of(1L,6L,15L,20L,15L,6L,1L)), new PascalLine(List.of(1L,7L,21L,35L,35L,21L,7L,1L)))
        );
    }
    @MethodSource("inputsNextLine")
    @ParameterizedTest
    void nextLine_should_return_expected_line(PascalLine givenPascalLine, PascalLine expectedPascalLine) {
        PascalLine actualPascalLine = givenPascalLine.nextLine();

        assertThat(actualPascalLine).isEqualTo(expectedPascalLine);
    }


    private static Stream<Arguments> inputsToString() {
        return Stream.of(
                Arguments.of(new PascalLine(Collections.singletonList(1L)), " 1 "),
                Arguments.of(new PascalLine(List.of(1L,1L)), " 1 1 "),
                Arguments.of(new PascalLine(List.of(1L,6L,15L,20L,15L,6L,1L)), " 1 6 15 20 15 6 1 ")
        );
    }
    @MethodSource("inputsToString")
    @ParameterizedTest
    void toString_should_return_expected_line(PascalLine givenPascalLine, String expectedPrintedLine) {
        String actualPrintedLine = givenPascalLine.toString();

        assertThat(actualPrintedLine).isEqualTo(expectedPrintedLine);
    }

}