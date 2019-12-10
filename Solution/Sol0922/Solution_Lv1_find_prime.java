package pgm;

import java.util.Scanner;

public class Solution_Lv1_find_prime {
	public static int solution(int n) {
		int answer = 0;
		int[] arr = new int[n + 1];
		// 2부터 n까지 배열 초기화
		for (int i = 2; i <= n; ++i) {
			arr[i] = i;
		}

		for (int i = 2; i <= n; ++i) {
			// 배열의 값이 0이면 소수가 아님
			if (arr[i] == 0)
				continue;
			else
				answer++;
			// 2 => 4, 6, 8 ,10 을 0으로
			// 3 => 6, 9 를 0으로
			// 자신의 배수를 0으로 체크하여 소수 판별 안하도록
			for (int j = i + i; j <= n; j += i) {
				arr[j] = 0;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(solution(n));
		sc.close();
	}

}
