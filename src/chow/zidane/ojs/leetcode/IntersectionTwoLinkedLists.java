package chow.zidane.ojs.leetcode;

class IntersectionTwoLinkedLists {

    static ListNode get(final ListNode a, final ListNode b) {
        if (a == null || b == null) return null;

        int lengthDelta = getLengthOfListNode(a) - getLengthOfListNode(b);
        ListNode iteratorA = a;
        ListNode iteratorB = b;

        if (lengthDelta > 0) {
            while(lengthDelta-- > 0) {
                iteratorA = iteratorA.next;
            }
        } else {
            while(lengthDelta++ < 0) {
                iteratorB = iteratorB.next;
            }
        }
        while (iteratorA != null && !iteratorA.equals(iteratorB)) {
            iteratorA = iteratorA.next;
            iteratorB = iteratorB.next;
        }

        return iteratorA;
    }

    private static int getLengthOfListNode(ListNode head) {
        int length = 1;
        while(head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
