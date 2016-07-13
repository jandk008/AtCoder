package chow.zidane.ojs.leetcode;

public class FindMedianSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int size = nums1.length + nums2.length;
		int res = findKth(nums1, nums2, 0, 0, nums1.length - 1, nums2.length - 1, (size / 2) + 1);
		if((size & 1) ==1){
			return res;
		}else{
			return (findKth(nums1, nums2, 0, 0, nums1.length - 1, nums2.length - 1, size / 2) + res) / 2.0; 
		}
	}
	public static int findKth(int[] a, int[] b, int l1, int l2, int r1, int r2, int k){
		int ak = Integer.MAX_VALUE;
		int bk = Integer.MAX_VALUE;
		if(r1 < l1 ){
			return b[l2 + k-1];
		}
		if(r2 < l2 ){
			return a[l1 + k-1];
		}
		if(k == 1){
			return Math.min(a[l1], b[l2]);
		}
		
		if(l1 + k/2 - 1<= r1){
			ak = a[l1 + k/2 - 1];
		}
		if(l2 + k/2 - 1 <= r2){
			bk = b[l2 + k/2 - 1];
		}
		if(ak < bk){
			return findKth(a, b, l1 + k / 2, l2, r1, l2 + k / 2 > r2 ? r2 : l2 + k / 2, k - k / 2);
		}else{
			return findKth(a, b, l1, l2 + k / 2, l1 + k / 2 > r1 ? r1 : l1 + k / 2, r2, k - k / 2);
		}
	}
	
	public static void  main(String[] args) {
		FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
		int[] i1 = {1,2,3,4,5,6,7,100};
		int[] i2 = {56,78,89,90,98,99};
		int[] i3 = {1,2};
		int[] i4 = {1,2};
//		int[] i2 = {};
//		System.out.println(findMedianSortedArrays.findKth(i1, i2, 0, 0, i1.length -1, i2.length - 1, 8));
//		System.out.println(findMedianSortedArrays.findMedianSortedArrays(i1, i2));
		System.out.println(findMedianSortedArrays.findMedianSortedArrays(i3, i4));
	}
}
