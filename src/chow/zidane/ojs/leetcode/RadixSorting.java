package chow.zidane.ojs.leetcode;

class RadixSorting {

    static int[] sort(final int[] nums) {
        int maximumNumber = findMax(nums);
        int digit = 1;
        while (maximumNumber != 0) {
            countingSort(nums, digit);
            digit *= 10;
            maximumNumber >>= 1;
        }
        return nums;
    }

    private static void countingSort(final int[] nums, final int digit) {
        int[] count = new int[10];
        for (final int num : nums) {
            int currentDigit = (num / digit) % 10;
            count[currentDigit]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        int[] output = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            output[count[(nums[i] / digit) % 10] - 1] = nums[i];
            count[(nums[i] / digit) % 10]--;
        }
        System.arraycopy(output, 0, nums, 0, nums.length);
    }

    private static int findMax(final int[] nums) {
        int max = Integer.MIN_VALUE;
        for (Integer i : nums) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
