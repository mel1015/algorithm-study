package d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution_D2_1974_스도쿠검증_서울9반_신광식 {
	public static String[][] map;
	public static TreeSet<String> digit, digit1;
	public static int answer = 1;

	public static boolean isSudoku(TreeSet<String> a) {
		if (a.size() == 9) {
			a.clear();
			return true;
		}
		a.clear();
		return false;
	}

	public static void countSudoku() {
		digit = new TreeSet<>();
		digit1 = new TreeSet<>();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				digit.add(map[j][i]);
				if (i % 3 == 0 && j % 3 == 0) {
					digit1.add(map[i][j]);
					digit1.add(map[i][j + 1]);
					digit1.add(map[i][j + 2]);
					digit1.add(map[i + 1][j]);
					digit1.add(map[i + 1][j + 1]);
					digit1.add(map[i + 1][j + 2]);
					digit1.add(map[i + 2][j]);
					digit1.add(map[i + 2][j + 1]);
					digit1.add(map[i + 2][j + 2]);
					if (!isSudoku(digit1)) {
						answer = 0;
						return;
					}
				}
			}
			if (!isSudoku(digit)) {
				answer = 0;
				return;
			}
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d2_1974.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			answer = 1;
			map = new String[9][9];
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				digit = new TreeSet<>();
				for (int j = 0; j < 9; j++) {
					map[i][j] = st.nextToken();
					digit.add(map[i][j]);
				}
				if (digit.size() != 9) {
					answer = 0;
				}
			}
			countSudoku();
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
