package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D3_1216_회문2_서울9반_신광식2 {
	static char[][] board;
	static int answer = 0;

	static void countPalindrome() {
		boolean found = false;
		for (int size = 100; size > 0; size--) {
			found = false;
			// (0행, 0열), (1행, 1열), ...
			for (int line = 0; line < board.length && !found; line++) {
				// 행 탐색
				for (int col = 0; col < board.length && !found; col++) {
					if (col + size > 100) {
						break;
					}
					StringBuffer sb = new StringBuffer();
					String str = sb.append(board[line], col, size).toString();
					String rev = sb.reverse().toString();
					if (str.equals(rev)) {
						answer = Math.max(answer, size);
						found = true;
						break;
					}
				}
				// 열 탐색
				for (int from = 0; from < board.length; from++) {
					if (from + size > 100) {
						break;
					}
					StringBuffer sb = new StringBuffer();
					for (int row = from; row < from + size; row++) {
						sb.append(board[row][line]);
					}
					String str = sb.toString();
					String rev = sb.reverse().toString();
					if (str.equals(rev)) {
						answer = Math.max(answer, size);
						found = true;
						break;
					}
				}

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