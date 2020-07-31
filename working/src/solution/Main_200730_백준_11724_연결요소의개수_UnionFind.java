package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_200730_백준_11724_연결요소의개수_UnionFind {
	static int n, m;
	static int[] parent;

	static int getParent(int x) {
		if (x == parent[x])
			return x;
		return parent[x] = getParent(parent[x]);
	}

	static void union(int x, int y) {
		x = getParent(x);
		y = getParent(y);
		if (x < y)
			parent[y] = x;
		else
			parent[x] = y;
	}

	static boolean findParent(int x, int y) {
		x = getParent(x);
		y = getParent(y);
		if (x == y)
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		parent = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			// 두 정점의 부모가 다르다면 union
			if (!findParent(x, y))
				union(x, y);
		}

		// 부모의 개수 => 연결 요소의 개수
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= n; i++) {
			set.add(getParent(parent[i]));
		}
		System.out.println(set.size());

		br.close();
	}
}