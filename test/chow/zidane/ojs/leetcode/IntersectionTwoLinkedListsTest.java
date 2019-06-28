package chow.zidane.ojs.leetcode;

import static chow.zidane.ojs.leetcode.assertions.ListNodeAssertions.assertEquals;

import chow.zidane.ojs.leetcode.converters.ToListNodeConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class IntersectionTwoLinkedListsTest {

    @ParameterizedTest
    @CsvSource( {"'1,2,3,4,5','8,7,4,5','4,5'", "'','1',''", "'1,3,4,5,6,7','3,4,5,6,7', '3,4,5,6,7'", "'4,5,6,7','3,4,5,6,7', '4,5,6,7'"})
    void test(
            @ConvertWith(ToListNodeConverter.class) ListNode A,
            @ConvertWith(ToListNodeConverter.class) ListNode B,
            @ConvertWith(ToListNodeConverter.class) ListNode expected) {
        assertEquals(expected, IntersectionTwoLinkedLists.get(A, B));
    }

}
