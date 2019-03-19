package chow.zidane.ojs.leetcode;

import java.util.function.Function;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
class PerfectSquares {

    /**
     * Dynamic programming, the minimum number for perfect square is 1, then for each i, look backwards using 2 pointers to find min {
     * n[left] + n[right]} where left + right = i
     */
    static class DynamicPrograming implements Function<Integer, Integer> {

        @Override
        public Integer apply(final Integer in) {
            int[] res = new int[in + 1];
            for (int i = 1; i < res.length; i++) {
                if (i * i <= in) {
                    res[i * i] = 1;
                }
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
}
