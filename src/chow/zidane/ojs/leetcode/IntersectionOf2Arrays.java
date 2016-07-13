package chow.zidane.ojs.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class IntersectionOf2Arrays {

	/**
	 * 1. Use Set to assure unique element. (14 ms) This solution is the first
	 * one popping up in my mind, using set to make sure the elements in result
	 * collection are unique, and using another collection container to keep
	 * track of iterated element, like method of Contains(). Analysis: However
	 * the call of contains() is the bottleneck of performance, since for each
	 * element, it will call contains() to check if it is iterated, which loops
	 * each element in the container wasting O(n') at maximum (n' is the size of
	 * collection, <= n). We assume that size of nums1 is n, size of nums2 is m,
	 * then T(n+m) = O(n*m) = O(n2), beating 12.9% submission, bad performance.
	 * 
	 * @author ziczhou
	 * 
	 */
	static class UseHashSet {
		public int[] intersection(int[] nums1, int[] nums2) {
			int n1 = nums1.length;
			int n2 = nums2.length;
			if (n1 == 0 || n2 == 0) {
				return new int[0];
			}
			Set<Integer> set = new HashSet<Integer>();
			List<Integer> array = new LinkedList<Integer>();
			for (int i = 0; i < n1; i++) {
				array.add(nums1[i]);
			}
			for (int i = 0; i < n2; i++) {
				if (array.contains(nums2[i])) {
					set.add(nums2[i]);
				}
			}
			int[] res = new int[set.size()];
			Iterator<Integer> iterator = set.iterator();
			int i = 0;
			while (iterator.hasNext()) {
				res[i++] = iterator.next();
			}
			return res;
		}
	}

	/**
	 * 2. Sort and Find. (5 ms) Although there is no restriction about the order
	 * of results, but if we sort it first and be able to solve this problem. At
	 * first, we have to analyze the lower bound respectively. For sorting,
	 * obviously known that there is linear time sorting, and binary search is
	 * the fastest way to search a key, but for an array with size of n, it is
	 * n*log n. Since two parts are independent, the lower bound of algorithm is
	 * n*log n. However it is faster much than solution 1, 5 ms against to 14
	 * ms. T(n) = O(nlogn), beating 93.14 % submission, pretty good.
	 * 
	 * @author ziczhou
	 * 
	 */
	static class SortAndFind {

		public int[] intersection(int[] nums1, int[] nums2) {
			int n1 = nums1.length;
			int n2 = nums2.length;
			if (n1 == 0 || n2 == 0) {
				return new int[0];
			}
			Arrays.sort(nums1);
			Arrays.sort(nums2);
			int i1 = 0;
			int i2 = 0;
			int i = 0;
			int[] res = new int[Math.min(n1, n2)];
			while (i1 < n1 && i2 < n2) {
				if (nums1[i1] == nums2[i2]) {
					res[i++] = nums1[i1];
					// move to next index
					i1 = nextIndex(nums1, i1);
					i2 = nextIndex(nums2, i2);
				} else if (nums1[i1] > nums2[i2]) {
					i2 = nextIndex(nums2, i2);
				} else {
					i1 = nextIndex(nums1, i1);
				}
			}
			return Arrays.copyOfRange(res, 0, i);
		}
		
		/**
		 * Find the next index pointing to different value with one of
		 * passed index
		 * @param a array 
		 * @param i current index
		 * @return next index
		 */
		public int nextIndex(int[] a, int i) {
			int n = a.length - 1;
			int cn = a[i];
			while (i <= n && a[i] == cn) {
				i++;
			}
			return i;
		}

		public static void main(String[] args) {
			System.out.println(": "
					+ new SortAndFind().intersection(new int[] { 1, 1 },
							new int[] { 1, 1 }));
		}
	}
}
