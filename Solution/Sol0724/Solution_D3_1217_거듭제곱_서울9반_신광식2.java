package d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D3_1217_거듭제곱_서울9반_신광식2 {

	static int solution(int a, int b) {
		if (b == 0)
			return 1;

		int n = solution(a, b / 2);
		int answer = n * n;
		if (b % 2 == 0) {
			return answer;
		} else {
			return answer * a;
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1217.txt"));
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();
			int answer = solution(n, m);
			System.out.println("#" + T + " " + answer);
		}
		sc.close();
	}

}
