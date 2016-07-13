package chow.zidane.ojs.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ReverseVowels {
    public String reverseVowels(String s) {
        if (null == s || s.length() == 0) {
  			return s;
  		}
  		char[] a = s.toCharArray();
  		Map<Character, String> map = new HashMap<Character, String>();
  		map.put('a', "a");
  		map.put('i', "i");
  		map.put('o', "o");
  		map.put('e', "e");
  		map.put('u', "u");
  		map.put('A', "a");;
  		map.put('I', "i");
  		map.put('O', "o");
  		map.put('E', "e");
  		map.put('U', "u");
  		int l = 0;
  		int r = s.length() - 1;
  		while (l < r) {
  			while (l < r && null == map.get(a[l])) {
  				l++;
  			}
  			while (l < r && null == map.get(a[r])) {
  				r--;
  			}
  			if (l < r) {
  				char tmp = a[l];
  				a[l] = a[r];
  				a[r] = tmp;
  			}
  			l++;
  			r--;
  		}
  		return String.valueOf(a);
      }
	public static void main(String[] args){
		System.out.println(new ReverseVowels().reverseVowels("hello"));
		LinkedList<Integer> list= new LinkedList<Integer>();
		list.addLast(1);
		list.isEmpty();
		list.removeFirst();
	}
}
