package chow.zidane.ojs.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class LargestDivisibleSet {

    static List<Integer> find(final int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);

        int[] count = new int[nums.length];
        int[] jump = new int[nums.length];
        Arrays.fill(count, 1);
        Arrays.fill(jump, -1);
        int max = 0, head = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && count[j] == count[i]) {
                    count[i] = count[j] + 1;
                    jump[i] = j;
                }
            }
            if (count[i] > max) {
                max = count[i];
                head = i;
            }
        }

        List<Integer> list = new ArrayList<>();
        while (head >= 0) {
            list.add(nums[head]);
            head = jump[head];
        }

        return list;
    }
}
