package chow.zidane.ojs.leetcode;


import java.util.Arrays;

public class RotateArray {

    class RotateSequentially {

        public void rotate(int[] nums, int k) {
            int index;
            k = k % nums.length;
            int startIndex = 0; // move to right when loop recursively
            int tmp; //keep the first value
            int tmmp = 0; // used as the temporary value when swap with tmp
            int i = 0; // sum number of finding new index, sum is equal to length
            while (i < nums.length) {
                //first time of index = startIndex, indicating loop when meet twice
                boolean isFirst = true;
                index = startIndex; // init index
                tmp = nums[index];
                while (index != startIndex || isFirst) {
                    index = (index + k) % nums.length;
                    tmmp = nums[index];
                    nums[index] = tmp;
                    tmp = tmmp;
                    isFirst = false;
                    i++;
                }
                startIndex++;
            }
        }
    }

    class RotateJuggling {

        public void rotate(int nums[], int k) {
            k = nums.length - k;
            int nRotated = 0;
            int firstToStart = 0;
            while (nRotated < nums.length && firstToStart < k) {
                int t = nums[firstToStart];
                int next = findNext(k, firstToStart, nums.length);
                int current = firstToStart;
                while (continues(next, firstToStart)) {
                    nums[current] = nums[next];
                    nRotated++;
                    current = next;
                    next = findNext(k, next, nums.length);
                }
                nums[current] = t;
                nRotated++;
                firstToStart++;
            }
        }

        private int findNext(int k, int next, int length) {
            return (k + next) % length;
        }

        private boolean continues(int next, int firstToStart) {
            return next != firstToStart;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        RotateArray rotateArray = new RotateArray();
        rotateArray.new RotateJuggling().rotate(nums, 2);
        Arrays.stream(nums).forEach(System.out::print);
        System.out.println();
        rotateArray.new RotateSequentially().rotate(nums, 3);
        Arrays.stream(nums).forEach(System.out::print);
    }
}
