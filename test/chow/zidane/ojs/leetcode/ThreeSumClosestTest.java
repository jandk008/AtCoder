package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import chow.zidane.ojs.leetcode.converters.ToIntegerArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class ThreeSumClosestTest {

    @ParameterizedTest
    @CsvSource({"'-1,2,1,-4',1,2", "'1,1,-1,-1,3',-1,-1"})
    void test(@ConvertWith(ToIntegerArrayConverter.class) int[] nums, int target, int expect) {
        assertEquals(expect, ThreeSumClosest.find(nums, target));
    }
}
