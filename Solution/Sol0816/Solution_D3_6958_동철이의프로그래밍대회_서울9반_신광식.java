package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_6958_동철이의프로그래밍대회_서울9반_신광식 {

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_6958.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int winnerCount = 0, solved = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int count = 0;
				for (int j = 0; j < m; j++) {
					count += Integer.parseInt(st.nextToken());
				}
				if (count > solved) {
					solved = count;
					winnerCount = 1;
				} else if (count == solved) {
					winnerCount++;
				}
			}
			System.out.println("#" + tc + " " + winnerCount + " " + solved);
		}
	}

}
