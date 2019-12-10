package d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D3_6730_장애물경주난이도_서울9반_신광식 {
	public static int N;

	public static int[] solve(int[] arr) {
		int[] answer = new int[2];
		int ascMax = 0;
		int descMax = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] < arr[i + 1]) {
				// 오르막
				ascMax = Math.max(ascMax, arr[i + 1] - arr[i]);
			} else if (arr[i] > arr[i + 1]) {
				// 내리막
				descMax = Math.max(descMax, arr[i] - arr[i + 1]);
			}
		}
		answer[0] = ascMax;
		answer[1] = descMax;
		return answer;
	}

	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			// 입력
			N = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			// 정답 출력
			int[] answer = solve(arr);
			System.out.println("#" + tc + " " + answer[0] + " " + answer[1]);
		}
		sc.close();
	}
}
