package chow.zidane.ojs.leetcode;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int mirror = 0;
		int o = x;
		while (o != 0) {
			mirror = mirror * 10 + o % 10;
			o = o / 10;
		}
		if (mirror == x) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(new PalindromeNumber().isPalindrome(143234));
	}
}
