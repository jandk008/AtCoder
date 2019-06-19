package chow.zidane.ojs.leetcode;

import chow.zidane.ojs.leetcode.converter.StringToIntegerArrayConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class LargestTimeForGivenDigitsTest {

    @ParameterizedTest
    @CsvSource( {"'1,2,3,4','23:41'", "'5,5,5,5',''", "'3,2,3,1','23:31'", "'5,1,3,3','15:33'", "'0,0,0,0','00:00'", "'1,2,0,5','21:50'",
            "'1,2,3,8','23:18'"})
    void test(@ConvertWith(StringToIntegerArrayConverter.class) int[] nums, String expected) {
        Assertions.assertEquals(expected, LargestTimeForGivenDigits.convert(nums));
    }
}
