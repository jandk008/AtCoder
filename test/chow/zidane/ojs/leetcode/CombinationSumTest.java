package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import chow.zidane.ojs.leetcode.converter.StringToIntegerArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class CombinationSumTest {

    @ParameterizedTest
    @CsvSource( {"'2,1,3','24','61'", "'2,1,3','12','19'", "'3,2,4,1','17','72'"})
    void combination(@ConvertWith(StringToIntegerArrayConverter.class) int[] nums, int target, int expect) {
        assertEquals(expect, CombinationSum.combinationSumWithCount(nums, target));
        assertEquals(expect, CombinationSum.combinationSumWithTrace(nums, target).size());
    }
}
