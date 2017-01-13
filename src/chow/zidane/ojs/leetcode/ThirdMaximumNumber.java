package chow.zidane.ojs.leetcode;

import java.util.LinkedList;
import java.util.List;

public class ThirdMaximumNumber {
    // public int thirdMax(int[] nums) {
    // int[] maxNums = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
    // int i =0;
    // for (;i < 3; i++) {
    // int max = max(nums);
    // maxNums[i] = max;
    // nums = remove(nums, max);
    // if (nums.length == 0)
    // break;
    // }
    // return i >=2 ? maxNums[2]:maxNums[0];
    // }
    public int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE, mid = max, min = max;
        for (int ele : nums) {
            if (ele > max) {
                min = mid;
                mid = max;
                max = ele;
            } else if (max > ele && ele > mid) {
                min = mid;
                mid = ele;
            } else if (mid > ele && ele > min) {
                min = ele;
            }
        }
        return (int) (min != Long.MIN_VALUE ? min : max);
    }

    public int[] remove(int[] a, int num) {
        List<Integer> removed = new LinkedList<>();
        for (int i : a) {
            if (i != num) {
                removed.add(i);
            }
        }
        return removed.stream().mapToInt(i -> i).toArray();
    }

    public int max(int[] a) {
        int max = Integer.MIN_VALUE;
        for (int i : a) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
