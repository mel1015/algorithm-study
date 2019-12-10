package d2;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution_D2_1983_조교의성적매기기_서울9반_신광식 {
	public static String[] grade = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1983.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[][] score = new int[n][2];

			for (int i = 0; i < score.length; i++) {
				score[i][0] = i + 1;
				score[i][1] += sc.nextInt() * 35;
				score[i][1] += sc.nextInt() * 45;
				score[i][1] += sc.nextInt() * 20;
			}

			Arrays.sort(score, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o2[1] - o1[1];
				}
			});

			String[] gotGrade = new String[n];
			String answer = "";
			int count = 0, idx = 0;
			while (count < n) {
				for (int i = 0; i < n / 10; i++) {
					gotGrade[count++] = grade[idx];
				}
				idx++;
			}
			for (int i = 0; i < gotGrade.length; i++) {
				if (score[i][0] == k) {
					answer += gotGrade[i];
					break;
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}
