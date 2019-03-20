package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import chow.zidane.ojs.leetcode.MissingNumber.ExclusiveOr;
import java.util.function.Function;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class MissingNumberTest {

    private Function<int[], Integer> function = new ExclusiveOr();

    @ParameterizedTest
    @CsvSource( {"'0',1", "'1',0", "'0,1',2", "'2,3,4,0',1", "'3,4,2,0',1", "'5,4,1,2,0',3"})
    void test(@ConvertWith(StringToIntArrayConverter.class) final int[] in, final int out) {
        assertEquals(out, function.apply(in).intValue());
    }
}
