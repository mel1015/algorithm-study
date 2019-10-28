package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution_D4_3459_승자예측하기_서울9반_신광식 {
	public static long n;
	public static String answer;

	public static void solution() {
		boolean isAlice = true;
		long sub = 1;
		while (n > 0) {
			n -= sub;
			if (isAlice) {
				sub *= 4;
			}
			isAlice = !isAlice;
		}
		answer = isAlice ? "Alice" : "Bob";
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_3459.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			n = Long.parseLong(br.readLine());
			solution();
			System.out.println("#" + tc + " " + answer);
		}
	}

}
