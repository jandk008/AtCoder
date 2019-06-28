package chow.zidane.ojs.leetcode;

import java.util.Objects;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ListNode)) {
            return false;
        }
        final ListNode listNode = (ListNode) o;
        return val == listNode.val && (next == null || next.equals(listNode.next));
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
