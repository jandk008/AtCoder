package chow.zidane.ojs.leetcode;

public class RemoveKthElement {

    public static ListNode remove(final ListNode head, int k) {
        if (k <= 0 || head == null) {
            return head;
        }
        if (k == 1) {
            return head.next;
        }
        ListNode previous = head;
        while (--k > 1 && previous.next != null) {
            previous = previous.next;
        }
        if (previous.next != null) {
            previous.next = previous.next.next;
        }
        return head;
    }
}
