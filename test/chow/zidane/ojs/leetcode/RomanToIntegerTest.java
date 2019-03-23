package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RomanToIntegerTest {

    @ParameterizedTest
    @CsvSource( {"I,1", "II,2", "III,3", "IV,4", "V,5", "VI,6", "VIII,8", "XIII,13", "XV,15", "XVIII,18", "XIX,19", "XX,20", "XXVIII,28",
            "XLIV,44", "CLXXX,180"})
    void test(String s, int n) {
        assertEquals(n, RomanToInteger.convert(s));
    }
}
