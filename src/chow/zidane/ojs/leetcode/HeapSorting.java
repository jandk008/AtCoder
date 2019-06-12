package chow.zidane.ojs.leetcode;

import static chow.zidane.ojs.util.CommonTool.swap;

class HeapSorting {

    static int[] sort(final int[] nums) {
        constructHeap(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapify(nums, 0, i);
        }
        return nums;
    }

    private static void heapify(int[] nums, int i, int size) {
        int swapIndex = i;

        int leftChild = 2 * i + 1;
        if (leftChild < size) {
            swapIndex = nums[leftChild] > nums[swapIndex] ? leftChild : swapIndex;
        }

        int rightChild = 2 * (i + 1);
        if (rightChild < size) {
            swapIndex = nums[rightChild] > nums[swapIndex] ? rightChild : swapIndex;
        }

        if (swapIndex != i) {
            swap(nums, swapIndex, i);
            heapify(nums, swapIndex, size);
        }
    }

    private static void constructHeap(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            heapify(nums, i, nums.length);
        }
    }
}
