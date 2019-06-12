package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import chow.zidane.ojs.leetcode.converter.StringToIntArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class HeapSortingTest {

    @ParameterizedTest
    @CsvSource({"'32,7,3,3,2,5,2,8,22,1','1,2,2,3,3,5,7,8,22,32'","'4,5,2,29,284,1,3,284,3823','1,2,3,4,5,29,284,284,3823'"})
    void test(@ConvertWith(StringToIntArrayConverter.class) int[] nums, @ConvertWith(StringToIntArrayConverter.class) int[] expected) {
        assertArrayEquals(expected, HeapSorting.sort(nums));
    }
}
