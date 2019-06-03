package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import chow.zidane.ojs.leetcode.converter.StringToIntArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class RadixSortingTest {

    @ParameterizedTest
    @CsvSource({"'32,1,3,3,2,5,2,8,22,7', '1,2,2,3,3,5,7,8,22,32'"})
    void test(@ConvertWith(StringToIntArrayConverter.class) int[] nums, @ConvertWith(StringToIntArrayConverter.class) int[] expected) {
        assertArrayEquals(expected, RadixSorting.sort(nums));
    }
}
