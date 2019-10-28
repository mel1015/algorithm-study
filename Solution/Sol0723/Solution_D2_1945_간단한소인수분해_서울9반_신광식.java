package d2;

import java.util.Scanner;

public class Solution_D2_1945_간단한소인수분해_서울9반_신광식 {
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/input_d2_1945.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// N = (2^a) * (3^b) * (5^c) * (7^d) * (11^e)
			int N = sc.nextInt();
			
			// 큰 수부터 나누기 위한 upper배열
			int[] upper = { 11, 7, 5, 3, 2 };
			int[] answer = new int[5];

			for (int i = 0; i < upper.length; i++) {
				int count = 0;
				// upper[i] 값으로 N을 나눈 나머지가 0이어야 약수
				while (N % upper[i] == 0) {
					// N을 upper[i]로 나눈 값으로 바꿔주고 count 증가
					N /= upper[i];
					count++;
				}
				// upper 배열의 순서가 큰 수 부터이므로 답은 역순
				answer[4 - i] = count;
			}
			// 정답 출력
			System.out.print("#" + tc + " ");
			for (int i = 0; i < answer.length; i++) {
				System.out.print(answer[i] + " ");
			}
			System.out.println();
		}
	}
}
