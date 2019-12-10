package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_6692_다솔이의월급상자_서울9반_신광식 {

	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/input_d3_5431.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			double answer = 0;
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				double prob = Double.parseDouble(st.nextToken());
				int money = Integer.parseInt(st.nextToken());
				answer += money * prob;
			}
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
