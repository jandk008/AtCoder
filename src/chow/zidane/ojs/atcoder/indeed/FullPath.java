/*
 * this algorithm iterates all path in a graph 
 */
package chow.zidane.ojs.atcoder.indeed;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FullPath {

	public static void main(String[] args) {
		new FullPath().run();
	}

	public void run() {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int computers = in.nextInt();
		int commands = in.nextInt();
		int[][] computer = new int[computers][computers];
		ArrayList<String> s = new ArrayList<String>();
		for (int n = 0; n < computers; n++) {
			for (int m = 0; m < computers; m++) {
				computer[n][m] = 0;
			}
		}

		for (int n = 0; n < commands; n++) {
			String c = in.next();
			if (c.equals("make")) {
				int i = in.nextInt() - 1;
				int j = in.nextInt() - 1;
				int time = in.nextInt();
				if (computer[i][j] == 0) {
					computer[i][j] = time;
					computer[j][i] = time;
				} else {
					if (computer[i][j] < time) {
						computer[j][i] = time;
					}
				}
				// update
				for (int a = 0; a < computers; a++) {
					for (int b = 0; b < computers; b++) {
						if (computer[i][a] == 0 || computer[b][j] == 0) {
							int max = Math.max(computer[i][a], computer[b][j]);
							max = Math.max(max, time);
							computer[a][b] = max;
						}
					}
				}
			} else {
				int i = in.nextInt() - 1;
				int j = in.nextInt() - 1;
				int time = in.nextInt();
				if (computer[i][j] == 0) {
					s.add("NO");
				} else if (computer[i][j] > time) {
					s.add("NO");
				} else {
					s.add("YES");
				}
			}
		}

		for (String i : s) {
			System.out.println(i);
		}

		in.close();
		out.close();
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

	public static void swap(int[] a, int n, int m) {
		int temp = a[m];
		a[m] = a[n];
		a[n] = temp;
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

}
