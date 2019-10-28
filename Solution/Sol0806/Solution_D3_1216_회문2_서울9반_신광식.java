package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D3_1216_회문2_서울9반_신광식 {
	static char[][] board;
	static int answer = 0;

	static void countPalindrome() {
		// 가로 탐색
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				// 홀수일 때
				// j-1, j+1 비교 >>> j-2, j+2 비교 >>> j-3, j+3 비교
				int depth = 1;
				while (j + depth < 100 && j - depth > 0 && board[i][j + depth] == board[i][j - depth]) {
					depth++;
				}
				if (depth != 1 && answer < depth * 2 - 1)
					answer = depth * 2 - 1;

				// 짝수일 때
				// j, j+1 비교 >>> j-1, j+2 비교 >>> j-2, j+3 비교
				depth = 0;
				while (j + depth + 1 < 100 && j - depth > 0 && board[i][j + depth + 1] == board[i][j - depth]) {
					depth++;
				}
				if (depth != 0 && answer < depth * 2)
					answer = depth * 2;
			}
		}
		// 세로 탐색
		for (int j = 0; j < 100; j++) {
			for (int i = 0; i < 100; i++) {
				// 홀수일 때
				// i-1, i+1 비교 >>> i-2, i+2 비교 >>> i-3, i+3 비교
				int depth = 1;
				while (i + depth < 100 && i - depth > 0 && board[i + depth][j] == board[i - depth][j]) {
					depth++;
				}
				if (depth != 1 && answer < depth * 2 - 1)
					answer = depth * 2 - 1;
				// 짝수일 때
				// i, i+1 비교 >>> i-1, i+2 비교 >>> i-2, i+3 비교
				depth = 0;
				while (i + depth + 1 < 100 && i - depth > 0 && board[i + depth + 1][j] == board[i - depth][j]) {
					depth++;
				}
				if (depth != 0 && answer < depth * 2)
					answer = depth * 2;
			}
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1216.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			answer = 0;
			int n = Integer.parseInt(br.readLine());
			board = new char[100][100];
			for (int i = 0; i < board.length; i++) {
				board[i] = br.readLine().toCharArray();
			}
			countPalindrome();
			System.out.println("#" + n + " " + answer);
		}
		br.close();
	}

}
