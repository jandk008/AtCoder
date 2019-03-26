package chow.zidane.ojs.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class LetterCombinationsOfAPhoneNumber {

    private static Map<Character, String[]> map;

    static {
        map = new HashMap<>();
        map.put('2', new String[] {"a", "b", "c"});
        map.put('3', new String[] {"d", "e", "f"});
        map.put('4', new String[] {"g", "h", "i"});
        map.put('5', new String[] {"j", "k", "l"});
        map.put('6', new String[] {"m", "n", "o"});
        map.put('7', new String[] {"p", "q", "r", "s"});
        map.put('8', new String[] {"t", "u", "v"});
        map.put('9', new String[] {"w", "x", "y", "z"});
    }

    static List<String> find(final String n) {
        if (n.length() == 0 || n.equals("1")) {
            return new ArrayList<>();
        }
        if (n.length() == 1) {
            return Arrays.stream(map.get(n.charAt(0))).collect(Collectors.toList());
        }
        List<String> rest = find(n.substring(1));
        List<String> res = new ArrayList<>();
        for (String c : map.get(n.charAt(0))) {
            for (String s : rest) {
                res.add(c + s);
            }
        }
        return res;
    }
}
