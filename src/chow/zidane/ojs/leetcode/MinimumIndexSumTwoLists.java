package chow.zidane.ojs.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MinimumIndexSumTwoLists {

    static String[] find(final String[] list1, final String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        List<String> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < list2.length && i <= min; i++) {
            if (map.containsKey(list2[i])) {
                int sum = map.get(list2[i]) + i;
                if (sum < min) {
                   min = sum;
                   list = new ArrayList<>();
                   list.add(list2[i]);
                } else if (sum == min) {
                    list.add(list2[i]);
                }
            }
        }

        return list.toArray(new String[0]);
    }
}
