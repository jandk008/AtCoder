package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import chow.zidane.ojs.leetcode.converter.StringToIntegerArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class LongestContainedIntervalTest {

    @ParameterizedTest
    @CsvSource( {"'1,-2,3,2','3'", "'3,-2,7,9,8,1,2,0,-1,5,8','6'", "'3,4,2,5,1,-2,100,3823','5'"})
    void test(@ConvertWith(StringToIntegerArrayConverter.class) int[] input, int expected) {
        assertEquals(expected, LongestContainedInterval.find(input));
    }

}
