package chow.zidane.ojs.leetcode;

public class LongestCommonPrefix {
	/**
	 * It is a basic solution that is easy to think up and implement. Use the
	 * first char of the first string to compare with the first chars of rest
	 * strings, append it into last of prefix and move to next char of first
	 * string if succeed, return the prefix if fails. T(n) = O(size of first
	 * string * size of strings), beating 40.07 %.
	 * 
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefix(String[] strs) {
		StringBuffer buffer = new StringBuffer();
		int size = strs.length;
		if (size == 0) {
			return "";
		}
		int index = 0;
		int length = strs[0].length();
		while (index < length) {
			char c = strs[0].charAt(index);
			boolean isSame = true;
			for (int i = 1; i < size; i++) {
				if (!check(strs[i], c, index)) {
					isSame = false;
					break;
				}
			}
			if (isSame) {
				buffer.append(c);
			} else {
				break;
			}
			index++;
		}
		return buffer.toString();
	}

	public boolean check(String s, char c, int index) {
		if (index >= s.length()) {
			return false;
		} else {
			return c == s.charAt(index);
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
		System.out
				.println(longestCommonPrefix.new BucketTheory()
						.longestCommonPrefix(new String[] { "sfsfsfhi", "sfsf",
								"sfsiu" }));
		System.out
				.println(new LongestCommonPrefix()
						.longestCommonPrefix(new String[] { "sfsfsfhi", "sfsf",
								"sfsiu" }));
	}

	/**
	 * Try to think about bucket theory which says how much water a bucket can
	 * hold is determined by the shortest board. The basic solution is running
	 * like this, compare the first two string to find the common longest
	 * string, then compare the rest strings one by one with the prefix which
	 * also is being updated in each compare. Why is this solution faster than
	 * above? The reason is that 1. it reduce the maximum length of chars to
	 * compare by reducing the length of prefix, 2. compare if they are equal
	 * instead of iterating each char to compare. Beats 80.01 % submission,
	 * pretty good.
	 * 
	 * @author ziczhou
	 * 
	 */
	class BucketTheory {
		public String longestCommonPrefix(String[] strs) {
			int size = strs.length;
			if (size == 0) {
				return "";
			}
			String prefix = strs[0];
			for (int i = 1; i < size; i++) {
				int length = Math.min(prefix.length(), strs[i].length());
				while (length > 0
						&& !strs[i].substring(0, length).equals(
								prefix.substring(0, length))) {
					length--;
				}
				prefix = prefix.substring(0, length);
			}
			return prefix;
		}
	}
}
