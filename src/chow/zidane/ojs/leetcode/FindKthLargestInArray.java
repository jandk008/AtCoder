package chow.zidane.ojs.leetcode;

public class FindKthLargestInArray {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargestFromScope(nums, 0, nums.length - 1, k);
    }

    private int findKthLargestFromScope(int[] arrayToFind, int leftBound, int rightBound, int k) {
        if (leftBound + 1 == rightBound) {
            if (arrayToFind[leftBound] < arrayToFind[rightBound]) {
                swap(arrayToFind, leftBound, rightBound);
            }
            return k == 1 ? arrayToFind[leftBound] : arrayToFind[rightBound];
        }
        int leftPointer = leftBound + 1;
        int rightPointer = rightBound;
        int pivat = arrayToFind[leftBound];
        while (hasMet(leftPointer, rightPointer)) {
            while (hasMet(leftPointer, rightPointer) && hasMet(leftPointer, rightBound) && arrayToFind[leftPointer] >= pivat) {
                leftPointer++;
            }
            while (rightPointer >= leftPointer && hasMet(leftBound, rightPointer) && arrayToFind[rightPointer] <= pivat) {
                rightPointer--;
            }
            if (hasMet(leftPointer, rightPointer)) {
                swap(arrayToFind, leftPointer, rightPointer);
            }
        }
        swap(arrayToFind, leftBound, rightPointer);
        int rank = rightPointer - leftBound + 1;
        if (k == rank) {
            return arrayToFind[rightPointer];
        } else if (k > rank) {
            return findKthLargestFromScope(arrayToFind, rightPointer + 1, rightBound, k - rank);
        } else {
            return findKthLargestFromScope(arrayToFind, leftBound, rightPointer, k);
        }
    }

    private boolean hasMet(int leftPointer, int rightPointer) {
        return leftPointer < rightPointer;
    }

    private void swap(int[] a, int leftPosition, int rightPosition) {
        int temp = a[leftPosition];
        a[leftPosition] = a[rightPosition];
        a[rightPosition] = temp;
    }

    public static void main(String[] args) {
        FindKthLargestInArray findKthLargestInArray = new FindKthLargestInArray();
        int[] nums = {5, 7, 8, 9, 23, 45, 12, 99, 5};
        int k = 7;
        System.out.println(findKthLargestInArray.findKthLargest(nums, k));
    }
}
