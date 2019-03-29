package chow.zidane.ojs.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import chow.zidane.ojs.leetcode.converter.StringToListNodeConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class MergeTwoSortedListTest {

    @ParameterizedTest
    @CsvSource( {"'1,2,4', '1,3,4', '1,1,2,3,4,4'", "'2,3,4,5', '2,3','2,2,3,3,4,5'", "'','',''"})
    void test(
            @ConvertWith(StringToListNodeConverter.class) ListNode l1,
            @ConvertWith(StringToListNodeConverter.class) ListNode l2,
            @ConvertWith(StringToListNodeConverter.class) ListNode expect) {
        ListNode merged = MergeTwoSortedList.merge(l1, l2);
        while (expect != null) {
            assertEquals(merged.val, expect.val);
            expect = expect.next;
            merged = merged.next;
        }
    }
}
