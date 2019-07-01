package chow.zidane.ojs.leetcode;

import java.util.Arrays;

class JumpGameWithMinimumSteps {

    static int jump(final int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int max = 0, steps = 0, index = 0;
        while (max < nums.length - 1) {
            int currentMax = max;
            for (int i = index; i <= currentMax; i++) {
                max = Math.max(max, i + nums[i]);
            }
            steps++;
            index = currentMax + 1;
        }

        return steps;
    }

    static int dynamicProgramming(final int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int[] cache = new int[nums.length];
        Arrays.fill(cache, Integer.MAX_VALUE);
        cache[0] = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length && j <= i + nums[i]; j++) {
                cache[j] = Math.min(cache[j], cache[i] + 1);
                if (j >= nums.length - 1) {
                    return cache[j];
                }
            }
        }

        return 0;
    }
}
