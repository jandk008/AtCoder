package chow.zidane.ojs.leetcode.assertions;

import static org.junit.jupiter.api.Assertions.assertNull;

import chow.zidane.ojs.leetcode.ListNode;
import org.junit.jupiter.api.Assertions;

public class ListNodeAssertions {

   public static void assertEquals(ListNode expected, ListNode actual) {
        while (expected != null && actual != null) {
            Assertions.assertEquals(expected.val, actual.val);
            expected = expected.next;
            actual = actual.next;
        }
        assertNull(actual);
        assertNull(expected);
    }

}
