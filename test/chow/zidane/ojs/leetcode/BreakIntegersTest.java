package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BreakIntegersTest {

    @ParameterizedTest
    @CsvSource( {"'2','1'", "'3','2'", "'4','4'", "'5','6'", "'6','9'", "'7', '12'", "'8','18'", "'9','27'", "'10','36'","'40','2125764'"})
    void test(int num, int expected) {
        assertEquals(expected, BreakIntegers.decompose(num));
    }

}
