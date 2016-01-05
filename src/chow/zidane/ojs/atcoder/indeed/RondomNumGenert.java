/*
 * this algorithm accept K ,N and calculate the Nth to N+4th number based the formular which is N+1th = (A*K+B)%M+N
 */
package chow.zidane.ojs.atcoder.indeed;

import java.io.PrintWriter;
import java.util.Scanner;

public class RondomNumGenert {

	int a;
	int b;
	int k;
	int m;

	public static void main(String[] args) {
		new RondomNumGenert().run();
	}

	public void run() {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		a = in.nextInt();
		b = in.nextInt();
		int x1 = in.nextInt();
		k = in.nextInt();
		m = in.nextInt();

		execute(x1, 1);

		in.close();
		out.close();
	}

	public void execute(int current, int n) {
		int next = (a * current + b) % m;
		if (n == k) {
			System.out.println(current);
			System.out.println(next);
			for (int j = 0; j < 3; j++) {
				next = (a * next + b) % m;
				System.out.println(next);
			}
			return;
		}
		execute(next, n + 1);
	}

}
