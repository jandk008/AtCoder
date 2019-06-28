package chow.zidane.ojs.leetcode;

import static chow.zidane.ojs.leetcode.assertions.ListNodeAssertions.assertListNodeEquals;

import chow.zidane.ojs.leetcode.converters.ToListNodeConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class MergeTwoSortedListTest {

    @ParameterizedTest
    @CsvSource( {"'1,2,4', '1,3,4', '1,1,2,3,4,4'", "'2,3,4,5', '2,3','2,2,3,3,4,5'", "'','',''"})
    void test(
            @ConvertWith(ToListNodeConverter.class) ListNode l1,
            @ConvertWith(ToListNodeConverter.class) ListNode l2,
            @ConvertWith(ToListNodeConverter.class) ListNode expected) {
        assertListNodeEquals(expected, MergeTwoSortedList.merge(l1, l2));
    }

}
