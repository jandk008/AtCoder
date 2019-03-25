package chow.zidane.ojs.leetcode;

import java.util.HashSet;
import java.util.Set;

class ThreeSumClosest {

    static int find(final int[] nums, final int target) {
        final Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
             sumTwo(nums, i+1).forEach(integer -> set.add(integer + t - target));
        }
        int res = Integer.MAX_VALUE;
        for (Integer integer : set) {
            res = Math.abs(integer) < Math.abs(res) ? integer : res;
        }
        return res + target;
    }

    private static Set<Integer> sumTwo(int[] nums,int l) {
        final HashSet<Integer> set = new HashSet<>();
        for (int i = l; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                 set.add(nums[i] + nums[j]);
            }
        }
        return set;
    }
}
