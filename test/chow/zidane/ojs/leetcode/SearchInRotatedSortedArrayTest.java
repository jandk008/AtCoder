package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import chow.zidane.ojs.leetcode.converters.ToIntegerArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class SearchInRotatedSortedArrayTest {

    @ParameterizedTest
    @CsvSource( {"'3,4,5,6,7,0,1,2','0','5'", "'4,5,6,7,8,1,2,3','8','4'", "'4,5,6,7,0,1,2','0','4'", "'2,3,4,0,1','5','-1'",
            "'5,1,3','3','2'"})
    void test(@ConvertWith(ToIntegerArrayConverter.class) int[] nums, int target, int expected) {
        assertEquals(expected, SearchInRotatedSortedArray.search(nums, target));
    }

}
