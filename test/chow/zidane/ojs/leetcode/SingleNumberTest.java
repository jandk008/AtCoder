package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import chow.zidane.ojs.leetcode.converters.ToIntegerArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class SingleNumberTest {

    @ParameterizedTest
    @CsvSource( {"'3,2,2,4,4',3", "0,0,-1,-1,2,2,-3',-3", "'2,2,4',4", "'3,2,2,4,4',3", "'1,0,1',0"})
    void test(@ConvertWith(ToIntegerArrayConverter.class) final int[] nums, final int out) {
        assertEquals(out, SingleNumber.ExclusiveOr.find(nums).intValue());
    }
}
