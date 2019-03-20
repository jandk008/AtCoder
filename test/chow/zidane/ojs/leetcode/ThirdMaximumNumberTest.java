package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import chow.zidane.ojs.leetcode.ThirdMaximumNumber.StoreTop3Max;
import java.util.function.Function;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class ThirdMaximumNumberTest {

    private Function<int[], Integer> function = new StoreTop3Max();

    @ParameterizedTest
    @CsvSource( {"'1,2',2", "'1,2,3',1", "'1,1,1,1,1',1", "'1,2,3,4,5,4',3", "'1,2,3,4,5',3"})
    void test(@ConvertWith(StringToIntArrayConverter.class) final int[] nums, final int out) {
        assertEquals(out, function.apply(nums).intValue());
    }
}
