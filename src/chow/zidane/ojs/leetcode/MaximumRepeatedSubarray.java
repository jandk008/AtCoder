package chow.zidane.ojs.leetcode;

class MaximumRepeatedSubarray {

    static int find(final int[] a, final int[] b) {
        if (a.length == 0 || b.length == 0) {
            return 0;
        }
        int[][] repeat = new int[a.length + 1][b.length + 1];
        int max = 0;

        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = b.length - 1; j >= 0; j--) {
                max = Math.max(max, repeat[i][j] = a[i] == b[j] ? repeat[i + 1][j + 1] + 1 : 0);
            }
        }
        return max;
    }
}
