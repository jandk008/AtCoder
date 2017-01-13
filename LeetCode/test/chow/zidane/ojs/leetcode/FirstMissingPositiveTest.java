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
        int[] nums = {34, 32, 38, 3, 4};
        int res = firstMissingPositive.firstMissingPositive(nums);
        assertEquals(1, res);
    }
    @Test
    public void allPositiveWith1() throws Exception {
        int[] nums = {24,23,12,1};
        int res = firstMissingPositive.firstMissingPositive(nums);
        assertEquals(2, res);
    }
    @Test
    public void allPositiveWith0() throws Exception {
        int[] nums = {23,41,32,0,1};
        int res = firstMissingPositive.firstMissingPositive(nums);
        assertEquals(2, res);
    }
    @Test
    public void withNegative() throws Exception {
        int[] nums = {32,2,4,-1,0,1};
        int res = firstMissingPositive.firstMissingPositive(nums);
        assertEquals(2, res);
    }
}
