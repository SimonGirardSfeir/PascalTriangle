package org.girardsimon;

import org.girardsimon.exception.ExcessiveSizeException;
import org.girardsimon.exception.ZeroOrNegativeSizeException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PascalTriangleTest {
    @Test
    void toString_should_return_expected_pascal_triangle_printed() {
        //Given
        PascalTriangle pascalTriangle = PascalTriangle.generate(5);

        //When
        String actualPrintedTriangle = pascalTriangle.toString();

        String expectedPrintedTriangle = """
                 1\s
                 1 1\s
                 1 2 1\s
                 1 3 3 1\s
                 1 4 6 4 1\s
                """;
        assertThat(actualPrintedTriangle).isEqualTo(expectedPrintedTriangle);
    }

    @Test
    void generate_should_return_ZeroOrNegativeSizeException_if_user_try_to_generate_PascalTriangle_with_negative_or_zero_size() {
        assertThatExceptionOfType(ZeroOrNegativeSizeException.class)
                .isThrownBy(() -> PascalTriangle.generate(-1));
    }

    @Test
    void generate_should_return_ExcessiveSizeException_if_user_try_to_generate_PascalTriangle_with_a_size_greater_than_67() {
        assertThatExceptionOfType(ExcessiveSizeException.class)
                .isThrownBy(() -> PascalTriangle.generate(68));
    }

}