package chow.zidane.ojs.leetcode;

class RadixSorting {

    static int[] sort(final int[] nums) {
        for (int exp = 1, maximumNumber = findMax(nums); maximumNumber > 0; maximumNumber /= 10, exp *= 10) {
            countingSort(nums, exp);
        }
        return nums;
    }

    private static void countingSort(final int[] nums, final int exp) {
        int[] count = new int[10];
        for (final int num : nums) {
            count[getDigit(num, exp)]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        int[] output = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            output[--count[getDigit(nums[i], exp)]] = nums[i];
        }
        System.arraycopy(output, 0, nums, 0, nums.length);
    }

    private static int getDigit(final int num, final int exp) {
        return (num / exp) % 10;
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
