package jo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main_정올_1863_종교_서울9반_신광식 {

	public static int getParent(Integer[] p, int x) {
		if (p[x] == x)
			return x;
		else
			return p[x] = getParent(p, p[x]);
	}

	public static void unionParent(Integer[] p, int a, int b) {
		a = getParent(p, a);
		b = getParent(p, b);
		if (a < b)
			p[b] = a;
		else
			p[a] = b;
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		if (m == 0) {
			System.out.println(n);
		} else {
			Integer[] p = new Integer[n];
			for (int i = 0; i < n; i++) {
				p[i] = i;
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				unionParent(p, a - 1, b - 1);
			}
			for (int i = 0; i < p.length; i++) {
				unionParent(p, i, i);
			}
			LinkedHashSet<Integer> set = new LinkedHashSet<Integer>(Arrays.asList(p));
			System.out.println(set.size());
		}
		br.close();
	}

}
