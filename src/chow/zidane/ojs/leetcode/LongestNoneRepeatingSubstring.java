package chow.zidane.ojs.leetcode;

import java.util.HashSet;
import java.util.Set;

class LongestNoneRepeatingSubstring {

    static int dynamicProgramming(final char[] a) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int start = 0;
        int end = start;
        while (end < a.length) {
            if (!set.contains(a[end])) {
                set.add(a[end]);
                end++;
            } else {
                max = Math.max(max, set.size());
                set.clear();
                while (++start < a.length && a[start] == a[start - 1]);
                end = start;
            }
        }
        return Math.max(max, set.size());
    }
}
