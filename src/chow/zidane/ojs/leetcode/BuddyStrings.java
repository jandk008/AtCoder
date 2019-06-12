package chow.zidane.ojs.leetcode;

import static chow.zidane.ojs.util.CommonTool.swap;

class BuddyStrings {

    static boolean is(final String a, final String b) {
        if ("".equals(a) || "".equals(b)) {
            return false;
        }
        if (a.length() != b.length()) {
            return false;
        }
        int diffCount = 0;
        int firstDiffIndex = -1;
        int secondDiffIndex = -1;
        char[] achars = a.toCharArray();
        char[] bchars = b.toCharArray();
        int[] count = new int[26];
        for (int i = 0; i < a.length(); i++) {
            count[achars[i] - 'a']++;
            if (achars[i] != bchars[i]) {
                if (diffCount == 2) {
                    return false;
                } else if (diffCount == 0) {
                    firstDiffIndex = i;
                } else {
                    secondDiffIndex = i;
                }
                diffCount++;
            }
        }

        if (diffCount == 1) {
            return false;
        } else if (diffCount == 2) {
            swap(achars, firstDiffIndex, secondDiffIndex);
            return String.valueOf(achars).equals(String.valueOf(bchars));
        } else {
            for (Integer i : count) {
                if (i > 1) {
                    return true;
                }
            }
            return false;
        }
    }
}
