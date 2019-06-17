package chow.zidane.ojs.leetcode;

import java.util.HashMap;
import java.util.Map;

class ShortestSubArray {

    static int find(final int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Appearance> map = new HashMap<>();
        int degree = 1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            Appearance appearance = map.putIfAbsent(nums[i], new Appearance(1, i));
            if (appearance != null) {
                appearance.count++;
                if (appearance.count > degree) {
                    degree = appearance.count;
                    min = i - appearance.start + 1;
                } else if (appearance.count == degree) {
                    min = Math.min(min, i - appearance.start + 1);
                }
            }
        }

        return degree == 1 ? 1 : min;
    }

    private static class Appearance {

        int count;
        int start;

        private Appearance(final int count, final int start) {
            this.count = count;
            this.start = start;
        }
    }
}
