package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class MissingNumberTest {

    @ParameterizedTest
    @CsvSource( {"'0',1", "'1',0", "'0,1',2", "'2,3,4,0',1", "'3,4,2,0',1", "'5,4,1,2,0',3"})
    void test(@ConvertWith(StringToIntArrayConverter.class) final int[] in, final int out) {
        assertEquals(out, MissingNumber.SumSubtraction.find(in));
        assertEquals(out, MissingNumber.ExclusiveOr.find(in));
    }
}
