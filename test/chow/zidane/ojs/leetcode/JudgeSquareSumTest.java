package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JudgeSquareSumTest {

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void test() {
        JudgeSquareSum judgeSquareSum = new JudgeSquareSum();
        int c = 10;
        assertTrue(judgeSquareSum.judgeSquareSum(c));
    }
}
