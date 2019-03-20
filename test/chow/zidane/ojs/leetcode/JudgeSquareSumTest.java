package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class JudgeSquareSumTest {

    private JudgeSquareSum judgeSquareSum;

    @BeforeEach
    void setUp() {
        judgeSquareSum = new JudgeSquareSum();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 5, 8, 9, 10, 13})
    void testTrueCase(final int n) {
        assertTrue(judgeSquareSum.judgeSquareSum(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 7, 6, 11, 12, 14, 15})
    void testFalseCase(final int n) {
        assertFalse(judgeSquareSum.judgeSquareSum(n));
    }
}
