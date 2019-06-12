package chow.zidane.ojs.leetcode;

import java.util.LinkedList;
import java.util.List;

class CombinationSum {

    static List<List<Integer>> combinationSumWithTrace(int[] nums, int target){
        List<List<Integer>> lists = new LinkedList<>();
        find(nums, target, 0, 0, new LinkedList<>(), lists);
        return lists;
    }

    private static void find(int[] nums, int target, int index, int sum, List<Integer> list, List<List<Integer>> lists) {
        if (sum == target) {
            lists.add(new LinkedList<>(list));
        } else {
            for (int i = index; i< nums.length; i++) {
                if (sum + nums[i] <= target) {
                    list.add(nums[i]);
                    find(nums, target, i, sum + nums[i], list, lists);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    static int combinationSumWithCount(int[] nums, int target) {
        int[] count = {0};
        combination(nums, 0, target, count);
        return count[0];
    }

    private static void combination(int[] nums, int index, int remaining, int[] count) {
        if (remaining == 0) {
            count[0]++;
            return;
        } else if (remaining < 0) return;

        for(int i = index; i < nums.length; i++) {
            if (nums[i] <= remaining) {
                combination(nums, i, remaining - nums[i], count);
            }
        }
    }
}
