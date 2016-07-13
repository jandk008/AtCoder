package chow.zidane.ojs.leetcode;

public class FindLongestPalindrome {
	public static String longestPalindrome(String s) {
		if (null == s || s.length() == 0) {
			return "";
		}
		if (s.length() == 1) {
			return s;
		}
		char[] a = s.toCharArray();
		char[] t = new char[a.length * 2 + 1];
		preprocess(t, a);
		int[] p = new int[t.length];
		// index of current longest palindrome center
		int C = 0;
		// index of maximum character in right side of the longest palindrome
		int R = 0;
		int n = t.length - 1;
		// calculate the p array
		for (int i = 0; i < t.length; i++) {
			int i_m = C * 2 - i;
			// when R = i, impling t[i] = '#', meaning p[i] = 0
			p[i] = R > i ? Math.min(R - i, p[i_m]) : 0;

			// update p[i] by expanding charater matching, if it is the center
			// of new longest palindrome
			// if R > i and R-i >= p[i_m], it will not update p[i], because T[i
			// + 1 + p[i]] != T[i_m - 1 - p[i]]
			while (i + 1 + p[i] <= n && i - 1 - p[i] >= 0
					&& t[i + 1 + p[i]] == t[i - 1 - p[i]]) {
				p[i]++;
			}
			// update C and R when expanded new right side exceeds the current
			// right side R
			if (i + p[i] > R) {
				R = i + p[i];
				C = i;
			}
		}

		// find the maximum in p array
		return findMax(s, p);
	}

	public static void preprocess(char[] t, char[] a) {
		t[0] = '#';
		int indexT = 1;
		for (int i = 0; i < a.length; i++) {
			t[indexT++] = a[i];
			t[indexT++] = '#';
		}
	}

	public static String findMax(String s, int[] p) {
		int maxLen = 0;
		int startIndex = 0;
		for (int i = 0; i < p.length; i++) {
			if (p[i] > maxLen) {
				maxLen = p[i];
				startIndex = (i - p[i]) / 2;
			}
		}
		return s.substring(startIndex, startIndex + maxLen);
	}
	
	public static void main(String[] args){
		System.out.println(FindLongestPalindrome.longestPalindrome("badfdsfiwruijsfabbbbbasdfsfsfsfhib"));
	}
}
