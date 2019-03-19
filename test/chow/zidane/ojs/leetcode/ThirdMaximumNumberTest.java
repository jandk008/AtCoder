package chow.zidane.ojs.leetcode;

import static chow.zidane.ojs.leetcode.TestUtils.toIntArray;
import static org.junit.jupiter.api.Assertions.assertEquals;

import chow.zidane.ojs.leetcode.ThirdMaximumNumber.StoreTop3Max;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ThirdMaximumNumberTest {

    public Executable executable;

    private static Stream<Arguments> getDataSource() {
        return Stream.of(
                Arguments.of(toIntArray(1, 2), 2),
                Arguments.of(toIntArray(1, 2, 3), 1),
                Arguments.of(toIntArray(1, 1, 1, 1, 1), 1),
                Arguments.of(toIntArray(1, 2, 3, 4, 5, 4), 3),
                Arguments.of(toIntArray(1, 2, 3, 4, 5), 3));
    }

    @BeforeEach
    void setUp() {
        executable = new StoreTop3Max();
    }

    @ParameterizedTest
    @MethodSource("getDataSource")
    void test(final int[] nums, final int out) {
        int k = 4;
        assertEquals(out, executable.execute(nums));
    }
}
