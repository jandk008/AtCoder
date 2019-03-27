package chow.zidane.ojs.leetcode;

class MergeTwoSortedList {

    static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode r = new ListNode(0);
        ListNode head = r;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                r.next = l1;
                l1 = l1.next;
            } else {
                r.next = l2;
                l2 = l2.next;
            }
            r = r.next;
        }
        if (l1 != null) {
            r.next = l1;
        }
        if (l2 != null) {
            r.next = l2;
        }
        return head.next;
    }
}
