package d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_D4_3124_최소스패닝트리_서울9반_신광식 {
	public static int V, E;
	public static List<int[]> v;
	public static int[] p;

	public static int findSet(int x) {
		if (p[x] == x)
			return x;
		else
			return p[x] = findSet(p[x]);
	}

	public static void union(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		if (a < b)
			p[b] = a;
		else
			p[a] = b;
	}

	public static long kruskal() {
		Collections.sort(v, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});

		p = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			p[i] = i;
		}

		long sum = 0;
		for (int i = 0; i < v.size(); i++) {
			if (findSet(v.get(i)[0]) != findSet(v.get(i)[1])) {
				sum += v.get(i)[2];
				union(v.get(i)[0], v.get(i)[1]);
			}
		}
		return sum;
	}

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input_d4_3124.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			v = new ArrayList<int[]>();
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				v.add(new int[] { a, b, weight });
			}
			System.out.println("#" + tc + " " + kruskal());
		}
		br.close();
	}

}
