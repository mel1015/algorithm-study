package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_200716_백준_9663_NQueen {
	static int n, answer;
	static int[] queenColNum;

	static boolean promising(int row) {
		for (int preRow = 0; preRow < row; preRow++) {
			// 같은 열에 있거나 대각선의 위치에 있을 때 불가능
			if (queenColNum[preRow] == queenColNum[row] || Math.abs(queenColNum[row] - queenColNum[preRow]) == (row - preRow)) {
				return false;
			}
		}
		return true;
	}

	static void nQueen(int row) {
		if (row == n) {
			answer++;
			return;
		}
		for (int col = 0; col < n; col++) {
			queenColNum[row] = col;
			if (promising(row))
				nQueen(row + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		queenColNum = new int[n];

		nQueen(0);
		System.out.println(answer);

		br.close();
	}
}