package chow.zidane.ojs.leetcode;

import java.util.Arrays;

class BreakIntegers {

    static int decompose(final int n) {
        if (n <= 0 || n == 1 || n == 2) {
            return 1;
        }
        int[] cache = new int[n + 1];
        Arrays.fill(cache, 1);

        for (int i = 3; i <= n; i++) {
            int max = 2;
            for (int j = i - 2; j >= 2; j--) {
                max = Math.max(max, Math.max(j, cache[j]) * (i - j));
            }
            cache[i] = max;
        }
        return cache[n];
    }
}
