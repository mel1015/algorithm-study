package d3;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_1209_Sum_서울9반_신광식 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1209.txt"));
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			int[][] arr = new int[100][100];
			int sumRow = 0, sumCol = 0, sumLx = 0, sumRx = 0;
			int answer = Integer.MIN_VALUE;

			for (int i = 0; i < arr.length; i++) {
				sumRow = 0;
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = sc.nextInt();
					// 행 더하기
					sumRow += arr[i][j];
					if (i == j) {
						// 왼쪽 대각선
						sumLx += arr[i][j];
					}
					if (i + j == arr.length - 1) {
						// 오른쪽 대각선
						sumRx += arr[i][j];
					}
				}
				// 최대값 갱신
				answer = Math.max(answer, sumRow);
			}
			// 열 더하기
			for (int j = 0; j < arr.length; j++) {
				sumCol = 0;
				for (int i = 0; i < arr[j].length; i++) {
					sumCol += arr[i][j];
				}
				answer = Math.max(answer, sumCol);
			}
			answer = Math.max(answer, sumRx);
			answer = Math.max(answer, sumLx);

			System.out.println("#" + T + " " + answer);
		}
	}
}
