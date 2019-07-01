package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import chow.zidane.ojs.leetcode.converters.ToIntegerArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class JumpGameTest {

    @ParameterizedTest
    @CsvSource( {"'2,3,1,1,4'", "'3,1,2,0,2,0'", "'2,2,3,0,2,0,1'", "'0'", "'2,0,0'"})
    void canJump(@ConvertWith(ToIntegerArrayConverter.class) int[] nums) {
        assertTrue(JumpGame.canJump(nums));
    }

    @ParameterizedTest
    @CsvSource( {"'3,2,1,0,4'", "'1,2,1,0,1,0'"})
    void canNotJump(@ConvertWith(ToIntegerArrayConverter.class) int[] nums) {
        assertFalse(JumpGame.canJump(nums));
    }

}
