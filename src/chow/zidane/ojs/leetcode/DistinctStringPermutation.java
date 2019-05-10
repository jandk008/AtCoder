package chow.zidane.ojs.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class DistinctStringPermutation {

    static List<String> recursionWithString(final String s) {
        List<String> list = new LinkedList<>();
        findPermutation(s, "", list);
        return list;
    }

    private static void findPermutation(String s, String prefix, List<String> list) {
        if (s.length() == 0) {
            list.add(prefix);
        }
        for (int i = 0; i < s.length(); i++) {
            findPermutation(s.substring(0, i) + s.substring(i + 1), prefix + s.charAt(i), list);
        }
    }

    static List<List<Integer>> recursionWithIntegerArray(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        findPermutationWithArray(nums, 0, nums.length - 1, lists);
        return lists;
    }

    private static void findPermutationWithArray(int[] nums, int i, int j, List<List<Integer>> lists) {
        if (i == j) {
            // performance purpose, stream is extremely slow comparing to simple for loop
            List<Integer> list = new ArrayList<>();
            for (Integer integer : nums) {
                list.add(integer);
            }
            lists.add(list);
        } else {
            for (int index = i; i <= j; i++) {
                swap(nums, i, index);
                findPermutationWithArray(nums, index + 1, j, lists);
                swap(nums, i, index);
            }
        }
    }

    private static void swap(final int[] nums, final int i, final int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
