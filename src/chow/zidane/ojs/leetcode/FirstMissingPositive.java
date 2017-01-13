package chow.zidane.ojs.leetcode;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i > max) {
                max = i;
            } else if (i < min) {
                min = i;
            }
        }
        int[] records = new int[max - min + 1];
        int length = records.length;
        int bucketNum = min;
        for (int i = 0; i < length; i++) {
            records[i] = bucketNum++;
        }
        for (int i : nums) {
            records[i - min] = 0;
        }
        if (min > 1) {
            return 1;
        } else if (min == 1 || min == 0) {
            for (int i : records) {
                if (records[i] != 0) {
                    return i;
                }
            }
        }
        return 0;
    }

}
