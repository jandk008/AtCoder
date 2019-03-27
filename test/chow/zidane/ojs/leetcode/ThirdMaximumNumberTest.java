package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import chow.zidane.ojs.leetcode.converter.StringToIntArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class ThirdMaximumNumberTest {

    @ParameterizedTest
    @CsvSource( {"'1,2',2", "'1,2,3',1", "'1,1,1,1,1',1", "'1,2,3,4,5,4',3", "'1,2,3,4,5',3"})
    void test(@ConvertWith(StringToIntArrayConverter.class) final int[] nums, final int out) {
        assertEquals(out, ThirdMaximumNumber.StoreTop3Max.find(nums).intValue());
    }
}
