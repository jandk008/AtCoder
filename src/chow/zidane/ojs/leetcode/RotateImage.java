package chow.zidane.ojs.leetcode;

class RotateImage {

    static void rotateWithSwapping(final int[][] matrix) {
        int length = matrix.length;
        for (int level = 0; level < length / 2; level++) {
            for (int i = level; i < length - level - 1; i++) {
                int t = matrix[level][i];
                matrix[level][i] = matrix[length - i - 1][level];
                matrix[length - i - 1][level] = matrix[length - level - 1][length - i - 1];
                matrix[length - level - 1][length - i - 1] = matrix[i][length - level - 1];
                matrix[i][length - level - 1] = t;
            }
        }
    }

    static void rotateWithFlipping(int[][] matrix) {
        transpose(matrix);
        flip(matrix);
    }

    private static void transpose(final int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }

    private static void flip(final int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = t;
            }
        }
    }
}
