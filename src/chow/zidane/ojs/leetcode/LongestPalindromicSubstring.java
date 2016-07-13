package chow.zidane.ojs.leetcode;

public class LongestPalindromicSubstring {
	/**
	 * 1. Dynamic Programming. (70 ms) We noticed that maximum length of S is
	 * 1000, which means it will not need huge storage to reduce time of
	 * computation, often using extra space to reduce time complexity. Here we
	 * use two division array to imply Si … Sj is palindrome with P[I,j] is
	 * true. Then we can expand the range from the center by setting P[i-1, j +
	 * 1] is true if S[I -1] = S[j+1]. The last thing I have to solve is where
	 * to start. For each single character, it is palindrome with length of 1,
	 * if the character next to it is the same, the two characters consist up a
	 * palindrome of length 2. Then we can compute the length of 3, 4, to length
	 * of S. When we calculate P[i,j], we use p[i+1,j-1] && s[i] == s[j]. T(n) =
	 * O(n2), with S(n) = O(n2), beating 30% submission.
	 * 
	 * @author ziczhou
	 * 
	 */
	class DynamicProgramming {
		public String longestPalindrome(String s) {
			if (null == s || s.length() == 0) {
				return "";
			}
			if (s.length() == 1) {
				return s;
			}
			char[] a = s.toCharArray();
			int beginIndex = 0;
			int maxLength = 1;
			int n = s.length();
			boolean[][] p = new boolean[s.length()][s.length()];
			// for single character
			for (int i = 0; i < n; i++) {
				p[i][i] = true;
			}
			// for palindrome length of 2, like "aa"
			for (int i = 0; i < n - 1; i++) {
				if (a[i] == a[i + 1]) {
					p[i][i + 1] = true;
					beginIndex = i;
					maxLength = 2;
				}
			}
			// for rest
			for (int len = 3; len <= n; len++) {
				for (int i = 0; i <= n - len; i++) {
					int j = i + len - 1;
					if (p[i + 1][j - 1] && a[i] == a[j]) {
						p[i][j] = true;
						beginIndex = i;
						maxLength = len;
					}
				}
			}
			return s.substring(beginIndex, beginIndex + maxLength);
		}
	}

	/**
	 * 2. Expand from center. (23 ms) In fact, this idea is improved from DP,
	 * using the symmetric property of palindrome. Here we have 2 cases, for
	 * "aba", the center is 'b' with the pattern of "XyX", in another side, for
	 * "abba", the center is between two 'b' with pattern of "XX". So we can
	 * just expand each possible center as much as possible, at last return the
	 * longest one. The different part with one of DP is reduction of extra
	 * space with O(1). Generally, it will produce good performance, but N2 time
	 * complexity for worst case. T(n) = O(n2), with S(n) = O(1), beating 65.48%
	 * submission, pretty good.
	 * 
	 * @author ziczhou
	 * 
	 */
	class ExpandCenter {
		public String longestPalindrome(String s) {
			if (null == s || s.length() == 0) {
				return "";
			}
			if (s.length() == 1) {
				return s;
			}
			char[] a = s.toCharArray();
			// int beginIndex = 0;
			int maxLength = 0;
			String res = "";
			int n = s.length();
			for (int i = 0; i < n - 1; i++) {
				String xyx = expand(a, i, i);
				if (xyx.length() > maxLength) {
					maxLength = xyx.length();
					res = xyx;
				}

				String xx = expand(a, i, i + 1);
				if (xx.length() > maxLength) {
					maxLength = xx.length();
					res = xx;
				}
			}
			return res;
		}

		/**
		 * Expand checked palindrome by comparing left character and right
		 * character of center
		 * 
		 * @param a
		 *            array to check
		 * @param low
		 *            left side of center, maybe equal to high
		 * @param high
		 *            right side of center, maybe equal to low
		 * @return
		 */
		public String expand(char[] a, int low, int high) {
			int l = low;
			int r = high;
			int n = a.length - 1;
			while (l >= 0 && r <= n && a[l] == a[r]) {
				l--;
				r++;
			}
			return String.copyValueOf(a, l + 1, r - l - 1);
		}
	}

	/**
	 * 3. Linear Time Solution, Manacher's alogrithm. (19 ms)
	 * http://articles.leetcode.com/longest-palindromic-substring-part-ii This
	 * is a linear solution, came up by Manacher. This algorithm use two tricky
	 * techniques to make it gracious: a. Insert '#' into between two
	 * characters, convert "abcd" into "#a#b#c#d#", so that can treat the
	 * original string generally without considering the length of longest
	 * palindrome is even or odd.( which is talked above, the pattern of longest
	 * palindrome are "XyX" and "XX". b. Take advantage of symmetric property of
	 * detected palindrome, to reduce the compare times with using ready
	 * calculated data. We use P array to imply the length of palindrome which
	 * put the center in the index i. When to decide the value of P[i], we use
	 * the existed value of P[i'], which i' is a symmetrical mirror of I against
	 * to center C as graph below, R is the right side boundary of palindrome C.
	 * So next step is how to calculate P[i].
	 * 
	 * Here we list three cases : a. i > R, no i' to refer, so we set it to 0,
	 * then update it with comparing each char b. i = R, because of inserted
	 * "#", R is always pointing to "#", the P[i] = 0. c. i < R, if P[i'] <= R -
	 * I, set P[i] to P[i'] because of symmetric property. Otherwise, P[i] =
	 * P[i'] , then update it.
	 * 
	 * How to compare: red lined shows characters to compare, instead of
	 * comparing the red lined chars, compare T[21] with green dotted
	 * line(T[9]), and T[9] = T[13] with symmetric property of palindrome center
	 * of C, meanwhile it also is equivalent to compare with T[1] by against to
	 * i' symmetrically, which is very important and gracious part in this
	 * algorithm. We can increase P[i] when detecting equality, simultaneously
	 * expand length of palindrome.
	 * 
	 * The last step is when to move the C and R, if i expands his right side
	 * exceeding the R, we can update C to i and R to i + P[i] Mentioned that
	 * this algorithm is linear, and T(n) = O(n) with space O(2n), beating 68.9
	 * % submission, comparative good to solution 2.
	 * 
	 * @author ziczhou
	 * 
	 */
	class ManacherAlgorithm {
		public String longestPalindrome(String s) {
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
			// index of maximum character in right side of the longest
			// palindrome
			int R = 0;
			int n = t.length - 1;
			// calculate the p array
			for (int i = 0; i < t.length; i++) {
				int i_m = C * 2 - i;
				// when R = i, impling t[i] = '#', meaning p[i] = 0
				p[i] = R > i ? Math.min(R - i, p[i_m]) : 0;

				// update p[i] by expanding charater matching, if it is the
				// center of new longest palindrome
				// if R > i and R-i >= p[i_m], it will not update p[i],
				// because T[i + 1 + p[i]] != T[i_m - 1 - p[i]]
				while (i + 1 + p[i] <= n && i - 1 - p[i] >= 0
						&& t[i + 1 + p[i]] == t[i - 1 - p[i]]) {
					p[i]++;
				}
				// update C and R when expanded new right side exceeds the
				// current right side R
				if (i + p[i] > R) {
					R = i + p[i];
					C = i;
				}
			}

			// find the maximum in p array
			return findMax(s, p);
		}

		/**
		 * Insert "#" into original string to convert
		 * 
		 * @param t
		 * @param a
		 */
		public void preprocess(char[] t, char[] a) {
			t[0] = '#';
			int indexT = 1;
			for (int i = 0; i < a.length; i++) {
				t[indexT++] = a[i];
				t[indexT++] = '#';
			}
		}

		public String findMax(String s, int[] p) {
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
	}

	/**
	 * 4. Brute Force. (TLE) Brute force is the easy way to think up, but here
	 * it will cause TLE with O(n3) time complexity. For reference, the code is
	 * listed below:
	 * 
	 * @author ziczhou
	 * 
	 */
	public String longestPalindrome(String s) {
		if (null == s || s.length() == 0) {
			return "";
		}
		if (s.length() == 1) {
			return s;
		}
		char[] a = s.toCharArray();
		int maxLength = 1;
		String res = "";
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (isPalindrome(a, i, j)) {
					if (j - i + 1 > maxLength) {
						maxLength = j - i + 1;
						res = s.substring(i, j + 1);
					}
				}
			}
		}
		return res;
	}

	/**
	 * Judge passed string is a palindrome or not
	 * 
	 * @param a
	 *            array to check
	 * @param low
	 *            left side
	 * @param high
	 *            right side
	 * @return
	 */
	public boolean isPalindrome(char[] a, int low, int high) {
		boolean res = true;
		if (low > high) {
			return false;
		} else if (low == high) {
			return true;
		}
		int l = low;
		int r = high;
		while (l < r) {
			if (a[l] != a[r]) {
				res = false;
			}
			l++;
			r--;
		}
		return res;
	}

}
