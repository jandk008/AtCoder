package chow.zidane.ojs.leetcode;

class DifferentLetter {

    static char find(final String s, final String t) {
        int i = 0;
        int added = 0;
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        while (i < schars.length) {
            added ^= schars[i] ^ tchars[i];
            i++;
        }
        added ^= tchars[i];

        return (char) added;
    }
}
