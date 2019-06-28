package chow.zidane.ojs.leetcode;

class ReverseListNodesInKGroup {

    static ListNode reverse(ListNode head, final int k) {
        if (k <= 1 || head == null) {
            return head;
        }
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode cur = h;
        int times = k;
        while (true) {
            ListNode groupHead = cur;
            while (times-- > 0 && cur != null) {
                cur = cur.next;
            }
            if (cur == null) {
                break;
            }
            ListNode groupTail = cur.next;
            ListNode[] reversedGroup = reverseGroup(groupHead.next, cur);
            groupHead.next = reversedGroup[0];
            reversedGroup[1].next = groupTail;
            cur = reversedGroup[1];
            times = k;
        }

        return h.next;
    }

    private static ListNode[] reverseGroup(ListNode head, ListNode tail) {
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode current = head.next;
        tail.next = null;
        while (current != null) {
            ListNode t = current.next;
            current.next = h.next;
            h.next = current;
            current = t;
        }
        return new ListNode[] {h.next, head};
    }
}
