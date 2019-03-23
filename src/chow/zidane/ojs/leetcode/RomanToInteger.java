package chow.zidane.ojs.leetcode;

class RomanToInteger {

    static int convert(String s) {
        int[] values = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int res = 0;
        while (!s.isEmpty()) {
            for (int i = 0; i < values.length; i++) {
                if (s.startsWith(romans[i])) {
                    res += values[i];
                    s = s.substring(romans[i].length());
                }
            }
        }
        return res;
    }
}
