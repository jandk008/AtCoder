package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RecursiveMultiplyTest {

    @ParameterizedTest
    @CsvSource( {"1,2,2", "2,2,4", "23,338,7774"})
    void multiple(int n1, int n2, int sum) {
        assertEquals(RecursiveMultiply.multiplyWithPlus(n1, n2), sum);
        assertEquals(RecursiveMultiply.multiplyWithBitShifting(n1,n2), sum);
    }
}
