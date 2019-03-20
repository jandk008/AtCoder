package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import chow.zidane.ojs.leetcode.SingleNumber.ExclusiveOr;
import java.util.function.Function;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class SingleNumberTest {

    private Function<int[], Integer> function = new ExclusiveOr();

    @ParameterizedTest
    @CsvSource( {"'3,2,2,4,4',3", "0,0,-1,-1,2,2,-3',-3", "'2,2,4',4", "'3,2,2,4,4',3", "'1,0,1',0"})
    void test(@ConvertWith(StringToIntArrayConverter.class) final int[] nums, final int out) {
        assertEquals(out, function.apply(nums).intValue());
    }
}
