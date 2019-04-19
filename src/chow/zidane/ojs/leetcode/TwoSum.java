package chow.zidane.ojs.leetcode;

class TwoSum {

    static boolean findRecursively(final int[] a, final int target) {
        return findRecursively(a, target, 0, 2);
    }

    private static boolean findRecursively(int[] a, int target, int index, int sumCount) {
        if (sumCount == 0 && target == 0) return true;
        if (sumCount < 0 || index >= a.length) {
            return false;
        }
        return findRecursively(a, target - a[index], index + 1, sumCount - 1)
                || findRecursively(a, target, index + 1, sumCount);
    }
}
