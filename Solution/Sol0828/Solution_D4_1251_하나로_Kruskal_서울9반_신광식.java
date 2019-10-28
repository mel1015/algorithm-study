package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_D4_1251_하나로_Kruskal_서울9반_신광식 {
	public static int N;
	public static double E;
	public static List<int[]> v;
	public static List<double[]> e;
	public static double[][] edge;
	public static int[] p;

	public static void makeEdge() {
		for (int i = 0; i < N; i++) {
			int x = v.get(i)[0];
			int y = v.get(i)[1];
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				int x2 = v.get(j)[0];
				int y2 = v.get(j)[1];
				double dis = Math.sqrt((Math.pow(x - x2, 2) + Math.pow(y - y2, 2)));
				edge[i][j] = dis;
				e.add(new double[] { i, j, edge[i][j] });
			}
		}
	}

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
		Collections.sort(e, new Comparator<double[]>() {
			@Override
			public int compare(double[] o1, double[] o2) {
				return Double.compare(o1[2], o2[2]);
			}
		});

		p = new int[N];
		for (int i = 0; i < N; i++) {
			p[i] = i;
		}
		double sum = 0;
		for (int i = 0; i < e.size(); i++) {
			int x = (int) e.get(i)[0];
			int y = (int) e.get(i)[1];
			if (findSet(x) != findSet(y)) {
				sum += Math.pow(e.get(i)[2], 2) * E;
				union(x, y);
			}
		}
		sum = Math.round(sum);
		return (long) sum;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1251.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st, st1;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			st1 = new StringTokenizer(br.readLine());
			E = Double.parseDouble(br.readLine());

			edge = new double[N][N];
			v = new ArrayList<int[]>();
			e = new ArrayList<double[]>();
			for (int i = 0; i < N; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st1.nextToken());
				v.add(new int[] { x, y });
			}
			makeEdge();
			System.out.println("#" + tc + " " + kruskal());
		}
		br.close();
	}

}
