package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import chow.zidane.ojs.leetcode.converter.StringToIntArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class TwoSumTest {

    @ParameterizedTest
    @CsvSource( {"'1,2,3,4', '4'", "'2,4,-1,5,1', '0'", "'2,5,3,1,8', '10'"})
    void testTrue(@ConvertWith(StringToIntArrayConverter.class) int[] a, int target) {
        assertTrue(TwoSum.findRecursively(a, target));
    }

    @ParameterizedTest
    @CsvSource( {"'1,2,3,4', '8'", "'2,4,-1,5,1', '10'", "'', '0'"})
    void testFalse(@ConvertWith(StringToIntArrayConverter.class) int[] a, int target) {
        assertFalse(TwoSum.findRecursively(a, target));
    }
}
