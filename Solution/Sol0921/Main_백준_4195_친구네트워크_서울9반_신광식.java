package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_백준_4195_친구네트워크_서울9반_신광식 {
	static int[] parent, relation;
	static StringBuilder sb;

	static int find(int x) {
		if (parent[x] == x)
			return x;
		else
			return parent[x] = find(parent[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y) {
			sb.append(relation[x] + "\n");
			return;
		}
		
		parent[x] = y;
		relation[y] += relation[x];
		sb.append(relation[y] + "\n");
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int f = Integer.parseInt(br.readLine());
			parent = new int[2 * f];
			relation = new int[2 * f];
			for (int i = 0; i < 2 * f; i++) {
				parent[i] = i;
				relation[i] = 1;
			}

			HashMap<String, Integer> hm = new HashMap<>();
			int idx = 0;
			for (int i = 0; i < f; i++) {
				st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();

				if (!hm.containsKey(a)) {
					hm.put(a, idx++);
				}
				if (!hm.containsKey(b)) {
					hm.put(b, idx++);
				}

				int ai = hm.get(a);
				int bi = hm.get(b);
				union(ai, bi);
			}
		}
		System.out.println(sb.toString());
		br.close();
	}

}
