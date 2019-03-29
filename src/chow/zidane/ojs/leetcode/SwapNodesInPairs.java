package chow.zidane.ojs.leetcode;

class SwapNodesInPairs {

    static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode l1 = head;
        ListNode l2 = head.next;
        ListNode h = head.next; // head that is returned

        // tali node that is assigned to l1 and connected to l2 after swapping
        ListNode t = new ListNode(0);
        t.next = l1;
        while (l1 != null && l1.next != null) {
            swap(t, l1, l2);
            t = l1;
            l1 = l1.next;
            if (l1 != null && l1.next != null) {
                l2 = l2.next.next.next;
            }
        }
        return h;
    }

    private static void swap(ListNode t, ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return;
        }
        l1.next = l2.next;
        l2.next = l1;
        t.next = l2;
    }
}
