package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BuddyStringsTest {

    @ParameterizedTest
    @CsvSource( {"'aa','aa'", "'aba','aab'", "'abba','aabb'", "'aaaaaabc','aaaaaacb'", "'aaab','aaab'", "'abab','abab'", "'aabb','aabb'"})
    void testTrue(String a, String b) {
        assertTrue(BuddyStrings.is(a, b));
    }

    @ParameterizedTest
    @CsvSource( {"'','aa'", "'',''", "'abcde','acbed", "'ab','ab'", "'abcd','acdb"})
    void testFalse(String a, String b) {
        assertFalse(BuddyStrings.is(a, b));
    }
}
