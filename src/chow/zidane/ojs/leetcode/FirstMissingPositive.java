package chow.zidane.ojs.leetcode;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int min = 0;
        int max = min;
        for (int i : nums) {
            if (i > max) {
                max = i;
            }
        }
        int[] records = new int[max - min + 1];
        int length = records.length;
        int bucketNum = min;
        for (int i = 0; i < length; i++) {
            records[i] = bucketNum++;
        }
        for (int i : nums) {
            if (i < 0)
                continue;
            records[i - min] = 0;
        }
        for (int i : records) {
            if (records[i] != 0) {
                return i;
            }
        }
        return length;
    }
    
    public int  firstMissingPositive2(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; ++ i)
            while(nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i])
                swap(nums, i , nums[i]-1);
        
        for(int i = 0; i < n; ++ i)
            if(nums[i] != i + 1)
                return i + 1;
        
        return n + 1;
    }
     public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}
