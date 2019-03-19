package chow.zidane.ojs.leetcode;

import static chow.zidane.ojs.leetcode.TestUtils.toIntArray;
import static org.junit.jupiter.api.Assertions.assertEquals;

import chow.zidane.ojs.leetcode.FirstMissingPositive.MaximumRange;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FirstMissingPositiveTest {

    private Executable firstMissingPositive = new MaximumRange();

    @ParameterizedTest
    @MethodSource("getDataSource")
    void test(final int[] nums, final int out) {
        assertEquals(out, firstMissingPositive.execute(nums));
    }

    static Stream<Arguments> getDataSource() {
        return Stream.of(
                Arguments.of(toIntArray(0), 1),
                Arguments.of(toIntArray(1), 2),
                Arguments.of(toIntArray(0, 1), 2),
                Arguments.of(toIntArray(2, 4, 5, 99), 1),
                Arguments.of(toIntArray(23, 41, 32, 0, 1), 2),
                Arguments.of(toIntArray(3, 4, -1, 1), 2),
                Arguments.of(toIntArray(23, 24, 1, 12), 2));

    }
}
