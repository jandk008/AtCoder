package chow.zidane.ojs.leetcode;

class IntegerToRoman {

    static String convert(int num) {
        int[] values = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                stringBuilder.append(romans[i]);
                num -= values[i];
            }
        }
        return stringBuilder.toString();
    }
}
