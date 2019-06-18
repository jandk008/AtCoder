package chow.zidane.ojs.leetcode;

import java.util.HashMap;
import java.util.Map;

class LongestNoneRepeatingSubstring {

    static int findWithMap(final char[] a) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        int end = start;
        while (end < a.length) {
            Integer previousId = map.put(a[end], end);
            if (previousId != null) {
                if (previousId >= start) {
                    max = Math.max(max, end - start);
                    start = previousId + 1;
                }
            }
            end ++;
        }
        return Math.max(max, end - start);
    }
}
