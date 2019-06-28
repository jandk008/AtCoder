package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import chow.zidane.ojs.leetcode.converters.ToIntegerArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class RadixSortingTest {

    @ParameterizedTest
    @CsvSource({"'32,7,3,3,2,5,2,8,22,1', '1,2,2,3,3,5,7,8,22,32'"})
    void test(@ConvertWith(ToIntegerArrayConverter.class) int[] nums, @ConvertWith(ToIntegerArrayConverter.class) int[] expected) {
        assertArrayEquals(expected, RadixSorting.sort(nums));
    }
}
