package chow.zidane.ojs.leetcode;

class WaterJugProblem {

    static boolean canMeasure(final int x, final int y, final int z) {
        return z == 0 || (x + y >= z && z % gcd(x, y) == 0);
    }

    private static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
}
