package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import chow.zidane.ojs.leetcode.converter.StringToIntArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class MaximumRepeatedSubarrayTest {

    @ParameterizedTest
    @CsvSource( {"'1,2,3,2,1','3,2,1,4,7','3'", "'3,2,1,2,3,4,5,8','8,2,7,2,3,4','3'", "'2,3,1,4,5,5','4,2,5,1,6,2','1'",
            "'1,2,3','4,5','0'", "'','1','0'", "'','','0'"})
    void test(@ConvertWith(StringToIntArrayConverter.class) int[] a, @ConvertWith(StringToIntArrayConverter.class) int[] b, int expected) {
        assertEquals(expected, MaximumRepeatedSubarray.find(a, b));
    }
}
