package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_D4_3289_서로소집합_서울9반_신광식 {
	public static int n, m;
	public static ArrayList<Edge> v;

	public static class Edge {
		int a;
		int b;

		public Edge(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	public static int getParent(int[] p, int x) {
		if (p[x] == x)
			return x;
		else
			return p[x] = getParent(p, p[x]);
	}

	public static void unionParent(int[] p, int a, int b) {
		a = getParent(p, a);
		b = getParent(p, b);
		if (a < b)
			p[b] = a;
		else
			p[a] = b;
	}

	public static boolean findParent(int[] p, int a, int b) {
		a = getParent(p, a);
		b = getParent(p, b);
		if (a == b)
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_3289.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			v = new ArrayList<Edge>();
			int[] p = new int[n];
			for (int i = 0; i < n; i++) {
				p[i] = i;
			}
			StringBuilder sb = new StringBuilder("#" + tc + " ");
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int cmd = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (cmd == 0) {
					unionParent(p, a - 1, b - 1);
				} else {
					if (findParent(p, a - 1, b - 1)) {
						sb.append(1);
					} else
						sb.append(0);
				}
			}
			System.out.println(sb);
		}
	}

}
