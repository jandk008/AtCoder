package chow.zidane.ojs.leetcode;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestThirdMaximumNumber {

    public ThirdMaximumNumber thirdMaximumNumber;

    @Before
    public void setUp() {
        thirdMaximumNumber = new ThirdMaximumNumber();
    }


    public int[] generateRepeatOnceInts() {
        int[] nums = {1, 2, 3, 4, 5, 4};
        return nums;
    }

    public int[] generateNoRepeatInts() {
        int[] nums = {1,2,3,4,5};
        return nums;
    }

    @Test
    public void testCreateObject() {
        assertNotNull(thirdMaximumNumber);
    }

    @Test
    public void testRemove() {
        int[] nums = generateRepeatOnceInts();
        int k = 4;
        nums = thirdMaximumNumber.remove(nums, k);
        assertEquals(nums.length, 4);
    }

    @Test
    public void testMax() {
        int[] nums = generateRepeatOnceInts();
        int k = 5;
        int max = thirdMaximumNumber.max(nums);
        assertEquals(k, max);
    }

    @Test
    public void noRepeat() throws Exception {
        int[] nums = generateNoRepeatInts();
        int  k = 3;
        assertEquals(k, thirdMaximumNumber.thirdMax(nums));
    }

    @Test
    public void allRepeat() throws Exception {
        int[] nums = {1,1,1,1,1};
        int k = 1;
        assertEquals(k, thirdMaximumNumber.thirdMax(nums));
    }
    
    @Test
    public void test3length() throws Exception {
        int[] nums = {1,2,3};
        int k = 1;
        assertEquals(k, thirdMaximumNumber.thirdMax(nums));
    }
    
    @Test
    public void testLessThan3Length() throws Exception {
        int[] nums = {1,2};
        int k = 2;
        assertEquals(k, thirdMaximumNumber.thirdMax(nums));
    }
    
}
