package d6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D6_1263_사람네트워크2_서울9반_신광식 {
	static int n;
	static int[][] dist;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d6_1263.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			dist = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dist[i][j] = Integer.parseInt(st.nextToken());
					if (i != j && dist[i][j] == 0)
						dist[i][j] = Integer.MAX_VALUE / 2;
				}
			}

			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
					}
				}
			}
			int answer = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				int sum = 0;
				for (int j = 0; j < n; j++) {
					sum += dist[i][j];
				}
				answer = Math.min(answer, sum);
			}
			System.out.println("#" + tc + " " + answer);
		}
	}

}
