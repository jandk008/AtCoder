package chow.zidane.ojs.leetcode;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
class MissingNumber {

    /**
     * Two things we can make sure are the scope of numbers may appear and only one number is missing from the scope. The difference
     * between sums of original scope and actual array is what we want. Improved point is using subtraction instead of addition to get
     * void of overflow.
     * T(n) = O(n), with S(n) = O(1), beats 43.66% submission.
     */
    static class SumSubtraction {

         static Integer find(final int[] ints) {
            int length = ints.length;
            int sum = length;
            for (int i = 0; i < length; i++) {
                sum = sum + i - ints[i];
            }
            return sum;
        }
    }

    /**
     * The feature of XOR we can use is doing xor twice with the same number will do nothing to original one. Like a ^ b ^ b = a. So, in
     * this case, index and value should appear correspondingly, which is for positions  [0,1,2,3], there should be numbers of 0,1,2,3 in
     * the array. If we xor the index with numbers, the left one should be the missing one.
     * T(n) = O(n), with S(n) = O(1) , beats 43.66% java submission.
     */
    static class ExclusiveOr {

        public static Integer find(final int[] ints) {
            int res = ints.length;
            for (int i = 0; i < ints.length; i++) {
                res ^= i ^ ints[i];
            }
            return res;
        }
    }
}
