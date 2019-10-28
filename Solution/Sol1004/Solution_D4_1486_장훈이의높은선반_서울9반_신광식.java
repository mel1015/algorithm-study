package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1486_장훈이의높은선반_서울9반_신광식 {
	static int n, b, answer;
	static int[] height;
	static boolean[] visit;

	static void dfs(int start, int cnt, int sum) {
		if (cnt > n)
			return;
		if (sum >= b) {
			answer = Math.min(answer, Math.abs(b - sum));
		}
		for (int i = start; i < height.length; i++) {
			if (!visit[i]) {
				visit[i] = true;
				dfs(i + 1, cnt + 1, sum + height[i]);
				visit[i] = false;
			}
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1486.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			height = new int[n];
			visit = new boolean[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			answer = Integer.MAX_VALUE;
			dfs(0, 0, 0);
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
