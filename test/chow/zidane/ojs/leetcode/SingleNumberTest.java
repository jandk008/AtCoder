package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import chow.zidane.ojs.leetcode.SingleNumber.ExclusiveOr;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SingleNumberTest {

    private Executable executable = new ExclusiveOr();

    @ParameterizedTest
    @MethodSource("getDataSource")
    void test(final int[] nums, final int out) {
        assertEquals(out, executable.execute(nums));
    }

    private static Stream<Arguments> getDataSource() {
        return Stream.of(
                Arguments.of(TestUtils.toIntArray(3, 2, 2, 4, 4), 3),
                Arguments.of(TestUtils.toIntArray(0, 0, -1, -1, 2, 2, -3), -3),
                Arguments.of(TestUtils.toIntArray(2, 2, 4), 4),
                Arguments.of(TestUtils.toIntArray(3, 2, 2, 4, 4), 3),
                Arguments.of(TestUtils.toIntArray(1, 0, 1), 0));
    }
}
