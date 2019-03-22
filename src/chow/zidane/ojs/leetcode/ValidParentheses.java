package chow.zidane.ojs.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

class ValidParentheses {

    static boolean is(final String s) {
        final Deque<Character> list = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            final Character peekLast = list.peekLast();
            if (peekLast == null || c == peekLast || Math.abs(c - peekLast) > 2) {
                list.add(c);
            } else if (c > peekLast && c - peekLast <= 2) {
                list.removeLast();
            } else {
                return false;
            }
        }
        return list.isEmpty();
    }
}
