package boj.Sol1024;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1719_별삼각형2_서울9반_신광식 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		if (n < 0 || n > 100 || n % 2 == 0 || m < 1 || m > 4)
			System.out.println("INPUT ERROR!");
		else {
			int mid = n / 2;
			if (m == 1) {
				for (int i = 0; i < mid; i++) {
					for (int j = 0; j <= i; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				for (int i = mid; i >= 0; i--) {
					for (int j = 0; j <= i; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
			} else if (m == 2) {
				for (int i = 0; i < mid; i++) {
					for (int j = 0; j < mid - i; j++) {
						System.out.print(" ");
					}
					for (int j = 0; j <= i; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				for (int i = mid; i >= 0; i--) {
					for (int j = 0; j < mid - i; j++) {
						System.out.print(" ");
					}
					for (int j = 0; j <= i; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
			} else if (m == 3) {
				for (int i = 0; i < mid; i++) {
					for (int j = 0; j < n; j++) {
						if (i == 0)
							System.out.print("*");
						else if (i > 0) {
							if (j <= i - 1 || j >= n - i)
								System.out.print(" ");
							else
								System.out.print("*");
						}
					}
					System.out.println();
				}
				for (int i = mid; i >= 0; i--) {
					for (int j = 0; j < n; j++) {
						if (j <= i - 1 || j >= n - i)
							System.out.print(" ");
						else
							System.out.print("*");
					}
					System.out.println();
				}
			} else if (m == 4) {
				for (int i = 0; i < mid; i++) {
					for (int j = 0; j <= mid; j++) {
						if (j >= i)
							System.out.print("*");
						else
							System.out.print(" ");
					}
					System.out.println();
				}
				for (int i = mid; i >= 0; i--) {
					for (int j = 0; j < mid; j++) {
						System.out.print(" ");
					}
					for (int j = 0; j < mid - i + 1; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
			}
		}
		br.close();
	}

}
