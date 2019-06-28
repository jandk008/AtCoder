package chow.zidane.ojs.leetcode.assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import chow.zidane.ojs.leetcode.ListNode;

public class ListNodeAssertions {

   public static void assertListNodeEquals(ListNode expected, ListNode actual) {
        while (expected != null && actual != null) {
            assertEquals(expected.val, actual.val);
            expected = expected.next;
            actual = actual.next;
        }
        assertNull(actual);
        assertNull(expected);
    }

}
