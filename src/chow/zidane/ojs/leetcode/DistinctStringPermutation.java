package chow.zidane.ojs.leetcode;

import java.util.LinkedList;
import java.util.List;

class DistinctStringPermutation {

    static List<String> recursion(final String s) {
        List<String> list = new LinkedList<>();
        findPermutation(s, "", list);
        return list;
    }

    private static void findPermutation(String s, String prefix, List<String> list) {
        if (s.length() == 0) list.add(prefix);
        for (int i = 0; i < s.length(); i++) {
            findPermutation(s.substring(0, i) + s.substring(i + 1), prefix + s.charAt(i), list);
        }
    }
}
