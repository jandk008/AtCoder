package chow.zidane.ojs.leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FrequnceSort {
    public String frequencySort(String s) {
        Map<Character, CharAndAppr> map = new HashMap<>();
        char[] chars = s.toCharArray();

        // count appearance
        for (char c : chars) {
            CharAndAppr charAndAppr = map.get(c);
            if (null == charAndAppr) {
                charAndAppr = new CharAndAppr(c, 1);
                map.put(c, charAndAppr);
            } else {
                charAndAppr.setN(charAndAppr.getN() + 1);
            }
        }

        // sort by appearance
        LinkedList<CharAndAppr> list = new LinkedList<CharAndAppr>(map.values());
        Collections.sort(list, new Comparator<CharAndAppr>() {
            @Override
            public int compare(CharAndAppr o1, CharAndAppr o2) {
                return o2.getN() - o1.getN();
            }
        });

        // print out
        StringBuffer stringBuffer = new StringBuffer();
        for (CharAndAppr charAndAppr : list) {
            int times = charAndAppr.getN();
            for (int n = 1; n <= times; n++) {
                stringBuffer.append(charAndAppr.getC());
            }
        }

        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        String s = "cccaaa";
        FrequnceSort sort = new FrequnceSort();
        System.out.println("result is " + sort.frequencySort(s));
    }

}

class CharAndAppr {
    char c;
    int n;

    CharAndAppr(char c, int n) {
        this.c = c;
        this.n = n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public int getN() {
        return n;
    }

}
