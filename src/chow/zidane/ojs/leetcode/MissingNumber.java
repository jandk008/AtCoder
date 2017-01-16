package chow.zidane.ojs.leetcode;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int length = nums.length;
        int miss = -1;
        int tmp;
        for (int i = 0; i < length; i++) {
            while(nums[i] != i){
                if (nums[i] == length) {
                    tmp = miss;
                    miss = nums[i];
                    nums[i] = tmp;
                }
                tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 0;i<length;i++){
            if (nums[i] == -1){
                return i;
            }
        }
        
        return length;
    }

}
