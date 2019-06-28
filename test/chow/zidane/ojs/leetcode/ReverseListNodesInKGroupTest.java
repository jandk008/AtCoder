package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import chow.zidane.ojs.leetcode.converter.ToListNodeConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class ReverseListNodesInKGroupTest {

    @ParameterizedTest
    @CsvSource( {"'1,2,3,4,5','2','2,1,4,3,5'", "'1,2,3,4,5','3','3,2,1,4,5'", "'1,2,3,4,5','5','5,4,3,2,1'", "'1,2,3','2','2,1,3'",
            "'1,2,3,4','2','2,1,4,3'", "'1,2,3,4,5','4','4,3,2,1,5'", "'1,2,3,4,5,6,7,8','4','4,3,2,1,8,7,6,5'"})
    void test(@ConvertWith(ToListNodeConverter.class) ListNode head, int k, @ConvertWith(ToListNodeConverter.class) ListNode expected) {
        ListNode actual = ReverseListNodesInKGroup.reverse(head, k);
        while (expected != null) {
            assertEquals(expected.val, actual.val);
            expected = expected.next;
            actual = actual.next;
        }
    }
}
