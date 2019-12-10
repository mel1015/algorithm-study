package d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D3_1204_최빈수구하기_서울9반_신광식 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1204.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int t = sc.nextInt();
			// 0점부터 100점까지 빈도수를 셀 배열
			int[] countNum = new int[101];
			for (int i = 0; i < 1000; i++) {
				// 값의 입력과 동시에 해당 인덱스(점수)의 값(빈도수)증가
				countNum[sc.nextInt()]++;
			}

			int max = 0, idx = 0;
			for (int i = 0; i < countNum.length; i++) {
				if (countNum[i] >= max) {
					// 빈도수가 같으면 높은 점수를 출력
					max = countNum[i];
					idx = i;
				}
			}
			System.out.println("#" + tc + " " + idx);
		}
		sc.close();
	}
}
