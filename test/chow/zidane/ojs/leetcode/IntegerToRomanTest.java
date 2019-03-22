package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class IntegerToRomanTest {

    @ParameterizedTest
    @CsvSource( {"1,I", "2,II", "3,III", "4,IV", "5,V", "6,VI", "8,VIII", "13,XIII", "15,XV", "18,XVIII", "19,XIX", "20,XX", "28,XXVIII",
            "44,XLIV", "180,CLXXX"})
    void test(int num, String s) {
        assertEquals(s, IntegerToRoman.convert(num));
    }

}
