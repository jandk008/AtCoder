package chow.zidane.ojs.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class FirstMissingPositiveTest {

    private FirstMissingPositive firstMissingPositive = new FirstMissingPositive();

    @Test
    public void newInstance() throws Exception {
        assertNotNull(firstMissingPositive);
    }

    @Test
    public void allPositiveGreaterThan1() throws Exception {
        int[] nums = { 2, 4, 5, 99 };
        int res = firstMissingPositive.firstMissingPositive(nums);
        int res2 = firstMissingPositive.firstMissingPositive2(nums);
        assertEquals(res, res2);
        assertEquals(1, res);
    }

    @Test
    public void allPositiveWith1() throws Exception {
        int[] nums = { 24, 23, 12, 1 };
        int res = firstMissingPositive.firstMissingPositive(nums);
        int res2 = firstMissingPositive.firstMissingPositive2(nums);
        assertEquals(res, res2);
        assertEquals(2, res);
    }

    @Test
    public void allPositiveWith0() throws Exception {
        int[] nums = { 23, 41, 32, 0, 1 };
        int res = firstMissingPositive.firstMissingPositive(nums);
        int res2 = firstMissingPositive.firstMissingPositive2(nums);
        assertEquals(res, res2);
        assertEquals(2, res);
    }

    @Test
    public void withNegative() throws Exception {
        int[] nums = { 3,4,-1,1 };
        int res = firstMissingPositive.firstMissingPositive(nums);
        int res2 = firstMissingPositive.firstMissingPositive2(nums);
        assertEquals(res, res2);
        assertEquals(2, res);
    }

    @Test
    public void single0() throws Exception {
        int[] nums = { 0 };
        int res = firstMissingPositive.firstMissingPositive(nums);
        int res2 = firstMissingPositive.firstMissingPositive2(nums);
        assertEquals(res, res2);
        assertEquals(1, res);
    }

    @Test
    public void single1() throws Exception {
        int[] nums = { 1 };
        int res = firstMissingPositive.firstMissingPositive(nums);
        int res2 = firstMissingPositive.firstMissingPositive2(nums);
        assertEquals(res, res2);
        assertEquals(2, res);
    }

    @Test
    public void OneAndZero() throws Exception {
        int[] nums = { 0, 1 };
        int res = firstMissingPositive.firstMissingPositive(nums);
        int res2 = firstMissingPositive.firstMissingPositive2(nums);
        assertEquals(res, res2);
        assertEquals(2, res);
    }
}
