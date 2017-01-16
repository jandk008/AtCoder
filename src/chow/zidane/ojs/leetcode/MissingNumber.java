package chow.zidane.ojs.leetcode;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int length = nums.length;
        int sum = length;
        for (int i = 0; i < length; i++) {
            sum = sum + i - nums[i];
        }

        return sum;
    }

}
