package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D3_7510_상원이의연속합_서울9반_신광식 {

	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/input_d3_5431.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int answer = 1, sum = 0, s = 1;
			for (int i = s; i < n; i++) {
				sum += i;
				if (sum == n) {
					sum = 0;
					answer++;
					i = s;
					s++;
					continue;
				} else if (sum > n) {
					sum = 0;
					i = s;
					s++;
					continue;
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
