package d4;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution_D4_4796_의석이의우뚝선산_서울9반_신광식 {
	static int n;
	static int[] mountain;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_4796.txt"));
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			mountain = new int[n];
			mountain[0] = sc.nextInt();
			mountain[1] = sc.nextInt();
			ArrayList<Integer> check = new ArrayList<>();
			for (int i = 2; i < n; i++) {
				mountain[i] = sc.nextInt();
				if (mountain[i - 2] < mountain[i - 1] && mountain[i - 1] > mountain[i]) {
					check.add(i - 1);
				}
			}
			int answer = 0;
			for (int i = 0; i < check.size(); i++) {
				answer++;
				int cntLeft = 0, cntRight = 0;
				int idx = check.get(i) - 1;
				while (idx - 1 >= 0) {
					int curr = mountain[idx];
					int left = mountain[idx - 1];
					if (curr > left) {
						answer++;
						cntLeft++;
						idx--;
					} else
						break;
				}
				idx = check.get(i) + 1;
				while (idx + 1 < n) {
					int curr = mountain[idx];
					int right = mountain[idx + 1];
					if (curr > right) {
						answer++;
						cntRight++;
						idx++;
					} else
						break;
				}
				answer += cntLeft * cntRight;
			}
			System.out.println("#" + tc + " " + answer);
		}
		sc.close();
	}

}
