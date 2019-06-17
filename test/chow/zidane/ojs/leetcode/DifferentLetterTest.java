package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DifferentLetterTest {

    @ParameterizedTest
    @CsvSource( {"'abacd','abaecd','e'", "'','a','a'", "'aaaa','aaaaa','a'"})
    void test(String s, String t, char expected) {
        assertEquals(expected, DifferentLetter.find(s, t));
    }
}
