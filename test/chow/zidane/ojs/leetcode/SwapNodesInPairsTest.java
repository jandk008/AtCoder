package chow.zidane.ojs.leetcode;

import static chow.zidane.ojs.leetcode.assertions.ListNodeAssertions.assertEquals;

import chow.zidane.ojs.leetcode.converters.ToListNodeConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class SwapNodesInPairsTest {

    @ParameterizedTest
    @CsvSource( {"'1,2','2,1'", "'1,2,3','2,1,3'", "'',''", "'1','1'", "'1,2,3,4','2,1,4,3'", "'1,2,3,4,5,6','2,1,4,3,6,5'"})
    void test(@ConvertWith(ToListNodeConverter.class) ListNode head, @ConvertWith(ToListNodeConverter.class) ListNode expected) {
        assertEquals(expected, SwapNodesInPairs.swapPairs(head));
    }

}
