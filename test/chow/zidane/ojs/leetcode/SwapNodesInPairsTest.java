package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import chow.zidane.ojs.leetcode.converter.ToListNodeConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class SwapNodesInPairsTest {

    @ParameterizedTest
    @CsvSource( {"'1,2','2,1'", "'1,2,3','2,1,3'", "'',''", "'1','1'", "'1,2,3,4','2,1,4,3'", "'1,2,3,4,5,6','2,1,4,3,6,5'"})
    void test(@ConvertWith(ToListNodeConverter.class) ListNode head, @ConvertWith(ToListNodeConverter.class) ListNode expect) {
        ListNode h = SwapNodesInPairs.swapPairs(head);
        while (expect != null) {
            assertEquals(h.val, expect.val);
            expect = expect.next;
            h = h.next;
        }
    }

}
