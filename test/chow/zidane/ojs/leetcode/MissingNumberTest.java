package chow.zidane.ojs.leetcode;

import static chow.zidane.ojs.leetcode.TestUtils.toIntArray;
import static org.junit.jupiter.api.Assertions.assertEquals;

import chow.zidane.ojs.leetcode.MissingNumber.ExclusiveOr;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MissingNumberTest {

    private Executable sut = new ExclusiveOr();

    @ParameterizedTest
    @MethodSource("getDataSource")
    void test(int[] in, int out) {
        assertEquals(out, sut.execute(in));
    }

    static Stream<Arguments> getDataSource() {
        return Stream.of(
                Arguments.of(toIntArray(0), 1),
                Arguments.of(toIntArray(1), 0),
                Arguments.of(toIntArray(0, 1), 2),
                Arguments.of(toIntArray(2, 3, 4, 0), 1),
                Arguments.of(toIntArray(3, 4, 2, 0), 1),
                Arguments.of(toIntArray(5, 4, 1, 2, 0), 3));
    }
}
