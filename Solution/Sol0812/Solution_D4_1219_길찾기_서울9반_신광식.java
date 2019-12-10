package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

public class Solution_D4_1219_길찾기_서울9반_신광식 {
	public static Pair[] edge;
	public static boolean[] visit;
	public static int answer = 0;

	public static class Pair {
		int from;
		int to;

		public Pair(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}

	public static void dfs(int start) {
		visit[start] = true;
		if (start == 99) {
			answer = 1;
			return;
		}
		for (int i = 0; i < edge.length; i++) {
			if (edge[i].from == start && !visit[edge[i].to]) {
				dfs(edge[i].to);
			}
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1219.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			visit = new boolean[100];
			edge = new Pair[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				edge[i] = new Pair(from, to);
			}
			answer = 0;
			dfs(0);
			System.out.println("#" + t + " " + answer);
		}
		br.close();
	}

}
