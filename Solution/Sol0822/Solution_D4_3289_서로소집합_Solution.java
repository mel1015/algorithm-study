package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3289_서로소집합_Solution {
	public static int[] p;

	public static int find(int x) {
		if (x == p[x])
			return x;
		else
			return p[x] = find(p[x]);
	}

	public static void union(int x, int y) {
		p[find(y)] = find(x);
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_3289.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			p = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				p[i] = i;
			}

			StringBuilder sb = new StringBuilder("#" + tc + " ");
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int cmd = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (cmd == 0) {
					union(a, b);
				} else {
					if (find(a) == find(b)) {
						sb.append(1);
					} else
						sb.append(0);
				}
			}
			System.out.println(sb);
		}
	}

}
