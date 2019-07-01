package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import chow.zidane.ojs.leetcode.converters.ToIntegerArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class MinimumInRotatedSortedArrayTest {

    @ParameterizedTest
    @CsvSource( {"'2,3,4,5,6,0,1','0'", "'1,2,3,4','1'", "'7,1,2,3,4,5','1'", "'2,3,4,5,6,7,-1,1','-1'", "'9,10,4,5,6,7,8','4'"})
    void test(@ConvertWith(ToIntegerArrayConverter.class) int[] nums, int expected) {
        assertEquals(expected, MinimumInRotatedSortedArray.find(nums));
    }

}
