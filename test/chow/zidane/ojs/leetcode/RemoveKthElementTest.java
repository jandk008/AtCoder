package chow.zidane.ojs.leetcode;

import static chow.zidane.ojs.leetcode.assertions.ListNodeAssertions.assertEquals;

import chow.zidane.ojs.leetcode.converters.ToListNodeConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

public class RemoveKthElementTest {

    @ParameterizedTest
    @CsvSource( {"'1', 2, '1'", "'1', 1, ''", "'1,2,3', 3, '1,2'", "'1,2,3,4,5', 5, '1,2,3,4'", "'1,2', 3, '1,2'", "'1,2,3', '2', '1,3'",
            "'1,2,3,4', 3, '1,2,4'"})
    void remove(@ConvertWith(ToListNodeConverter.class) ListNode head, int k, @ConvertWith(ToListNodeConverter.class) ListNode expected) {
        assertEquals(expected, RemoveKthElement.remove(head, k));
    }
}
