package chow.zidane.ojs.leetcode;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MissingNumberTest {

    private MissingNumber missingNumber = new MissingNumber();

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void createInstance() {
        assertNotNull(missingNumber);
    }

    @Test
    public void isSingleNumber1() throws Exception {
        int[] nums = { 1 };
        int res = missingNumber.missingNumber(nums);
        assertEquals(0, res);
    }

    @Test
    public void isSingleNumber0() throws Exception {
        int[] nums = { 0 };
        int res = missingNumber.missingNumber(nums);
        assertEquals(1, res);
    }

    @Test
    public void isConsecutiveArray() throws Exception {
        int[] nums = { 0, 1 };
        int res = missingNumber.missingNumber(nums);
        assertEquals(2, res);
    }

    @Test
    public void missIntermediaryNumber() throws Exception {
        int[] nums = { 2, 3, 4, 0 };
        int res = missingNumber.missingNumber(nums);
        assertEquals(1, res);
    }

    @Test
    public void missIntermediaryNumber2() throws Exception {
        int[] nums = { 3, 2, 4, 0 };
        int res = missingNumber.missingNumber(nums);
        assertEquals(1, res);
    }

}
