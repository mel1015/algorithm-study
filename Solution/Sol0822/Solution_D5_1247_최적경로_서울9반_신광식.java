package d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_D5_1247_최적경로_서울9반_신광식 {
	public static ArrayList<Pos> pos;
	public static Pos comp, home;
	public static int n, answer;
	public static int[] d;

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void swap(int i, int j) {
		if (i == j)
			return;
		int T = d[i];
		d[i] = d[j];
		d[j] = T;
	}

	public static void perm(int count) {
		if (count == n) {
			findRoute(d);
			return;
		}
		for (int i = count; i < n; i++) {
			swap(count, i);
			perm(count + 1);
			swap(count, i);
		}
	}

	public static void findRoute(int[] d) {
		int result = 0;
		int fromX = comp.x, fromY = comp.y;
		for (int i = 0; i < d.length; i++) {
			int toX = pos.get(d[i] - 1).x, toY = pos.get(d[i] - 1).y;
			result += Math.abs(fromX - toX) + Math.abs(fromY - toY);
			fromX = toX;
			fromY = toY;
		}
		result += Math.abs(fromX - home.x) + Math.abs(fromY - home.y);
		answer = Math.min(answer, result);
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d5_1247.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());

			d = new int[n];
			for (int i = 1; i <= n; i++) {
				d[i - 1] = i;
			}

			st = new StringTokenizer(br.readLine());

			pos = new ArrayList<Pos>();
			comp = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			for (int i = 0; i < n; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				pos.add(new Pos(x, y));
			}
			answer = Integer.MAX_VALUE;
			perm(0);
			System.out.println("#" + tc + " " + answer);
		}
	}

}
