package chow.zidane.ojs.leetcode;



public class RotateArray {
	public static void rotate(int[] nums, int k) {
        int index = 0;
        k = k % nums.length;
        int startIndex = 0; // move to right when loop recursively
        int tmp = nums[index]; //keep the first value 
        int tmmp = 0; // used as the temporary value when swap with tmp
        int i = 0; // sum number of finding new index, sum is equal to length
        while (i < nums.length){
        	//first time of index = startIndex, indicating loop when meet twice
        	boolean isFirst = true;
        	index = startIndex; // init index
        	tmp = nums[index];
        	while (index != startIndex || isFirst ){
        		index = (index + k) % nums.length;
        		tmmp = nums[index];
        		nums[index] = tmp;
        		tmp = tmmp;
        		isFirst = false;
        		i++;
        	}
        	startIndex ++;
        }
    }
	public static void main (String[] args){
		int[] nums = {1,2,3,4,5,6};
		rotate(nums, 2);
		System.out.println();
	}
}
