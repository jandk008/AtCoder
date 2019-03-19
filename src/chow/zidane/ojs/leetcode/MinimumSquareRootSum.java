package chow.zidane.ojs.leetcode;

public class MinimumSquareRootSum {

    public static int get(final int in) {
        int[] res = new int[in + 1];
        for (int i = 1; i < res.length; i++) {
            if (i * i <= in) {
                res[i * i] = 1;
            }
        }
        for (int i = 1; i < res.length; i++) {
            if (res[i] == 1) {
                continue;
            }
            int l = 1;
            int r = i - 1;
            int min = Integer.MAX_VALUE;
            while (l <= r) {
                min = res[l] + res[r] < min ? res[l] + res[r] : min;
                l++;
                r--;
            }
            res[i] = min;
        }
        return res[in];
    }
}
