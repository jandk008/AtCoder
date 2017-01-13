package chow.zidane.ojs.util;

import java.util.Arrays;

public class CommonTool {

    public static void swap(int[] a, int n, int m) {
        int temp = a[m];
        a[m] = a[n];
        a[n] = temp;
    }

    public static void swap(char[] a, int n, int m) {
        char temp = a[m];
        a[m] = a[n];
        a[n] = temp;
    }

    public static int binarySearch(char[] a, int low, int high, int target) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        if (a[mid] == target) {
            return mid;
        } else if (a[mid] > target) {
            return binarySearch(a, low, mid - 1, target);
        } else {
            return binarySearch(a, mid + 1, high, target);
        }
    }

    public static int binarySearch(int[] a, int low, int high, int target) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        if (a[mid] == target) {
            return mid;
        } else if (a[mid] > target) {
            return binarySearch(a, low, mid - 1, target);
        } else {
            return binarySearch(a, mid + 1, high, target);
        }
    }

    public static void quickSort(int[] a, int low, int high) {
        if (low >= high)
            return;
        if (low + 1 == high) {
            if (a[low] > a[high]) {
                swap(a, low, high);
            }
            return;
        }
        int l = low + 1;
        int r = high;
        int pivat = a[low];
        while (l < r) {
            while (l < r && l < high) {
                if (a[l] > pivat)
                    break;
                l++;
            }
            while (r >= l && r > low) {
                if (a[r] < pivat)
                    break;
                r--;
            }
            if (l < r) {
                swap(a, l, r);
            }
        }
        swap(a, low, r);
        quickSort(a, low, r);
        quickSort(a, r + 1, high);
    }

    public static void quickSort(char[] a, int low, int high) {
        if (low >= high)
            return;
        if (low + 1 == high) {
            if (a[low] > a[high]) {
                swap(a, low, high);
            }
            return;
        }
        int l = low + 1;
        int r = high;
        int pivat = a[low];
        while (l < r) {
            while (l < r && l <= high) {
                if (a[l] > pivat)
                    break;
                l++;
            }
            while (r >= l && r > low) {
                if (a[r] < pivat)
                    break;
                r--;
            }
            if (l < r) {
                swap(a, l, r);
            }
        }
        swap(a, low, r);
        quickSort(a, low, r);
        quickSort(a, r + 1, high);
    }

    public static void testFilter() {
        int[] array = {1,26,4,2,7,8,5,23,9,10};
        Arrays.stream(array).filter(x -> {return x > 5;}).forEach(x -> System.out.print(x + ","));
    }
}
