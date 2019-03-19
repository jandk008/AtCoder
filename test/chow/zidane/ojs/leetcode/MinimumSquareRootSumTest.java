package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MinimumSquareRootSumTest {
    @ParameterizedTest
    @MethodSource("argumentsProvider")
    void test(int in, int out) {
        assertEquals(out, MinimumSquareRootSum.get(in));
    }

    private static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 3),
                Arguments.of(4, 1),
                Arguments.of(8, 2),
                Arguments.of(13, 2),
                Arguments.of(12, 3));
    }
}
