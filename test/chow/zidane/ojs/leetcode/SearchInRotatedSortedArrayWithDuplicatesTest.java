package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import chow.zidane.ojs.leetcode.converters.ToIntegerArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class SearchInRotatedSortedArrayWithDuplicatesTest {

    @ParameterizedTest
    @CsvSource( {"'3,4,5,0,0,1,2','0'", "'2,5,6,0,0,1,2','2'", "'1,3,1,1,1','3'", "'1,1,1,1,2','2'", "'1,1,1,3,1','3'","'2,2,3,4,4,0,1,1','0'"})
    void exists(@ConvertWith(ToIntegerArrayConverter.class) int[] nums, int target) {
        assertTrue(SearchInRotatedSortedArrayWithDuplicates.search(nums, target));
    }

    @ParameterizedTest
    @CsvSource( {"'3,4,5,0,0,1,2','7'", "'2,5,6,0,0,1,2','3'", "'1,1,1,1,2','3'"})
    void doNotExist(@ConvertWith(ToIntegerArrayConverter.class) int[] nums, int target) {
        assertFalse(SearchInRotatedSortedArrayWithDuplicates.search(nums, target));
    }

}
