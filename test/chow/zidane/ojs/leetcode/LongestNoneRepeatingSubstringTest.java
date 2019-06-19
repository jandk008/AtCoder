package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LongestNoneRepeatingSubstringTest {

    @ParameterizedTest
    @CsvSource( {"'aaaabbbbabcde','5'", "'acaabbbba','2'", "'aaacbaabbbbb','3'", "'n','1'", "'jjjjj','1'", "'aab','2'"})
    void test(String a, int expected) {
        assertEquals(expected, LongestNoneRepeatingSubstring.findWithMap(a.toCharArray()));
    }
}
