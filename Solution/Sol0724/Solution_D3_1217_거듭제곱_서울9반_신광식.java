package d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D3_1217_거듭제곱_서울9반_신광식 {
	// 재귀 호출 함수
	static int solution(int a, int b, int answer) {
		// answer *= a를 b번 해서 b==0일때 리턴
		if (b > 0)
			answer *= a;
		else
			return answer;
		return solution(a, b - 1, answer);
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1217.txt"));
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();
			int answer = solution(n, m, 1);
			System.out.println("#" + T + " " + answer);
		}
		sc.close();
	}

}
