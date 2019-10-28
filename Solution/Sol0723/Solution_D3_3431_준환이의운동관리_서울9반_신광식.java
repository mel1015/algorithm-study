package d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D3_3431_준환이의운동관리_서울9반_신광식 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_3431.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int L = sc.nextInt();
			int U = sc.nextInt();
			int X = sc.nextInt();
			int answer = 0;

			if (X < L)
				answer = L - X;
			else if (X > U)
				answer = -1;
			else
				answer = 0;

			System.out.println("#" + tc + " " + answer);
		}
	}

}
