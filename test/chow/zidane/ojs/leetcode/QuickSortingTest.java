package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import chow.zidane.ojs.leetcode.converter.StringToIntegerArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class QuickSortingTest {

    @ParameterizedTest
    @CsvSource( {"'32,1,3,3,2,5,2,8,22,7','1,2,2,3,3,5,7,8,22,32'",
            "'3,424,122,24,1344,535,11,34,1324,14,134,1413,3,141,1,1,34','1,1,3,3,11,14,24,34,34,122,134,141,424,535,1324,1344,1413'"})
    void test(@ConvertWith(StringToIntegerArrayConverter.class) int[] nums, @ConvertWith(StringToIntegerArrayConverter.class) int[] expected) {
        assertArrayEquals(expected, QuickSorting.sort(nums));
    }
}
