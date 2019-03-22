package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import chow.zidane.ojs.leetcode.PerfectSquares.DynamicPrograming;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PerfectSquaresTest {

    @ParameterizedTest
    @CsvSource( {"1,1", "2,2", "3,3", "4,1", "9,1", "8,2", "13,2", "12,3"})
    void test(int in, int out) {
        assertEquals(out, new DynamicPrograming().apply(in).intValue());
    }
}
