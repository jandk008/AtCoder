package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LongestNoneRepeatingSubstringTest {

    @ParameterizedTest
    @CsvSource( {"'aaaabbbbabcde','5'", "'acaabbbba','2'", "'aaacbaabbbbb','3'", "'n','1'", "'jjjjj','1'"})
    void test(String a, int expect) {
        assertEquals(expect, LongestNoneRepeatingSubstring.findWithMap(a.toCharArray()));
    }
}
