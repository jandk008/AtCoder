package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import chow.zidane.ojs.leetcode.converters.ToIntegerArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class JumpGameWithMinimumStepsTest {

    @ParameterizedTest
    @CsvSource( {"'2,3,1,1,4','2'", "'3,1,2,0,2,0','3'", "'2,2,3,0,2,0,1','3'", "'2','0'", "'2,0,0','1'", "'1,1,3,2,1','3'",
            "'1,1,1,3,3,1,1,2,1,2','6'"})
    void test(@ConvertWith(ToIntegerArrayConverter.class) int[] nums, int expected) {
        assertEquals(expected, JumpGameWithMinimumSteps.jump(nums));
        assertEquals(expected, JumpGameWithMinimumSteps.dynamicProgramming(nums));
    }

}
