package chow.zidane.ojs.leetcode;

class JumpGame {

    static boolean canJump(final int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int max = 0;
        for (int i = 0; i < nums.length && i <= max; i++) {
            max = Math.max(max, i + nums[i]);
        }
        return max >= nums.length - 1;
    }
}
