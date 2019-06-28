package chow.zidane.ojs.leetcode;

import chow.zidane.ojs.leetcode.converters.ToIntegerArrayConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class ShortestSubArrayTest {

    @ParameterizedTest
    @CsvSource( {"'1,2,2,3,1','2'", "'1,2,2,3,1,4,2','6'", "'1,2,3,4,5,6','1'", "'','0'", "'4,2,1,5,3,5,6,6','2'"})
    void test(@ConvertWith(ToIntegerArrayConverter.class) int[] nums, int expected) {
        Assertions.assertEquals(expected, ShortestSubArray.find(nums));
    }
}
