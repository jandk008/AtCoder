package chow.zidane.ojs.leetcode;

class SingleNumber {

    /**
     * The feature of XOR we can use is doing xor twice with the same number will do nothing to
     * original one. Like a ^ b ^ b = a. So, in this case, the number appearing twice will be
     * removed by xor while single number will be left. T(n) = O(n) with S(1), beats 36.9% java
     * submission.
     */
    static class ExclusiveOr {

        static Integer find(final int[] nums) {
            int xor = 0;
            for (final int num : nums) {
                xor ^= num;
            }
            return xor;
        }
    }
}
