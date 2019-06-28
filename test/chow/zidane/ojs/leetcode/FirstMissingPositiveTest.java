package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import chow.zidane.ojs.leetcode.converters.ToIntegerArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class FirstMissingPositiveTest {

    @ParameterizedTest
    @CsvSource( {"'0, 1', 2", "'0', 1", "'1', 2", "'2, 4, 5, 99', 1", "'23, 41, 32, 0, 1', 2", "'3, 4, -1, 1', 2", "'23, 24, 1, 12', 2"})
    void test(@ConvertWith(ToIntegerArrayConverter.class) final int[] nums, final int out) {
        assertEquals(out, FirstMissingPositive.MaximumRange.find(nums).intValue());
        assertEquals(out, FirstMissingPositive.Swap.find(nums).intValue());
    }
}
