package chow.zidane.ojs.leetcode;

class JudgeSquareSum {

    boolean judgeSquareSum(int c) {
        int right = (int) Math.floor(Math.sqrt(c));
        int left = 0;
        while (left <= right) {
            int offset = c - left * left - right * right;
            if (offset == 0) {
                return true;
            } else if (offset > 0) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
