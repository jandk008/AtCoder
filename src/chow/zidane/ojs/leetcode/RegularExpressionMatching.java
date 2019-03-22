package chow.zidane.ojs.leetcode;

class RegularExpressionMatching {

    static boolean recursive(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        if (p.length() > 1 && p.charAt(1) == '*') {
            return recursive(s, p.substring(2)) || !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
                    && recursive(s.substring(1), p);
        } else {
            return !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && recursive(s.substring(1), p.substring(1));
        }
    }
}
