package jo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1863_종교_Solution {
	public static int[] p;

	public static int getParent(int x) {
		if (p[x] == x)
			return x;
		else
			return p[x] = getParent(p[x]);
	}

	public static void unionParent(int a, int b) {
		int pa = getParent(a);
		int pb = getParent(b);
		if (pa != pb)
			p[pb] = pa;
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			unionParent(a - 1, b - 1);
		}
		int answer = 0;
		for (int i = 0; i < p.length; i++) {
			if (p[i] == i)
				answer++;
		}
		System.out.println(answer);
		br.close();
	}

}
