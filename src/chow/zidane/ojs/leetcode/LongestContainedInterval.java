package chow.zidane.ojs.leetcode;

import java.util.HashSet;
import java.util.Set;

class LongestContainedInterval {

    static int find(final int[] input) {
        Set<Integer> set = new HashSet<>();
        for (Integer i : input) {
            set.add(i);
        }
        int max = 0;
        for (Integer i : input) {
            int length = 1;
            int extend = i - 1;
            while (set.contains(extend)) {
                length++;
                set.remove(extend--);
            }
            extend = i + 1;
            while (set.contains(extend)) {
                length++;
                set.remove(extend++);
            }
            max = Math.max(max, length);
        }
        return max;
    }
}
