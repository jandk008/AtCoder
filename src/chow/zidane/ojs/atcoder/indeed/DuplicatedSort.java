package chow.zidane.ojs.atcoder.indeed;
/*
 * This algorithm solves the question that counters the number of duplicated words and print them in ascend order
 */
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import chow.zidane.ojs.util.CommonTool;

public class DuplicatedSort {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		String s = in.next();
		char[] a = s.toCharArray();
		CommonTool.quickSort(a, 0, a.length - 1);
		List<MyNode> myList = new ArrayList<MyNode>();
		int counter = 1;
		char c = a[0];
		MyNode node;
		for (int n = 1; n < a.length; n++) {
			if (a[n] != c) {
				node = new MyNode(c, counter);
				myList.add(node);
				c = a[n];
				counter = 1;
				if (n == a.length - 1) {
					myList.add(new MyNode(c, counter));
				}
				continue;
			}
			counter++;
			if (n == a.length - 1) {
				myList.add(new MyNode(c, counter));
			}
		}
		Collections.sort(myList);
		// myList.sort(new MyComparator());
		display(myList);
		in.close();
		out.close();
	}

	public static void display(List<MyNode> a) {
		for (MyNode n : a) {
			System.out.println(n.c);
		}
	}

	public static void display(char[] a) {
		for (char n : a) {
			System.out.println(n);
		}
	}

	

	
}

class MyNode implements Comparable<MyNode> {
	char c;
	int number;

	MyNode(char c, int number) {
		this.c = c;
		this.number = number;
	}

	public int compareTo(MyNode a) {
		if (this.number != a.number) {
			return a.number - this.number;
		} else {
			return this.c - a.c;
		}
	}

}

class MyComparator implements Comparator<MyNode> {
	public int compare(MyNode a, MyNode b) {
		if (a.number != b.number) {
			return b.number - a.number;
		} else {
			return a.c - b.c;
		}
	}
}
