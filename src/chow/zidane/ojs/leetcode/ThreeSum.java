package chow.zidane.ojs.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {

    static List<List<Integer>> find(final int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        if (nums[0] > 0) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                final int t = nums[i] + nums[l] + nums[r];
                if (t == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    do {
                        l++;
                    } while (l < r && nums[l] == nums[l - 1]);
                    do {
                        r--;
                    } while (l < r && nums[r] == nums[r + 1]);
                } else if (t > 0) {
                    do {
                        r--;
                    } while (l < r && nums[r] == nums[r + 1]);
                } else {
                    do {
                        l++;
                    } while (l < r && nums[l] == nums[l - 1]);
                }
            }
        }
        return res;
    }
}
