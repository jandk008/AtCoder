package chow.zidane.ojs.leetcode;

class RegularExpressionMatching {

    static class Recursive {
        static boolean match(String s, String p) {
            if (p.isEmpty()) {
                return s.isEmpty();
            }
            if (p.length() > 1 && p.charAt(1) == '*') {
                return match(s, p.substring(2)) || !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
                        && match(s.substring(1), p);
            } else {
                return !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && match(s.substring(1), p.substring(1));
            }
        }
    }

    static class DynamicProgramming {
        static boolean match(String s, String p) {
            int m = s.length();
            int n = p.length();
            boolean[][] res = new boolean[m + 1][n + 1];
            res[0][0] = true;
            for (int i = 1; i < res.length; i++) {
                res[i][0] = false;
            }
            for (int j = 1; j < res[0].length; j++) {
                res[0][j] = j > 1 && p.charAt(j - 1) == '*' && res[0][j - 2]; // 'x*' matches empty
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (p.charAt(j - 1) == '*') {
                        res[i][j] = res[i][j - 2] || res[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.');
                    } else {
                        res[i][j] = res[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                    }
                }
            }
            return res[m][n];
        }
    }
}
