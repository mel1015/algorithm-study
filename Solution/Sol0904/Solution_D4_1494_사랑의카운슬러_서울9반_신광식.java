package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_D4_1494_사랑의카운슬러_서울9반_신광식 {
	public static int n;
	public static long answer;
	public static boolean[] visit;
	public static ArrayList<int[]> worms, halfWorms;

	public static void dfs(int next, int cnt) {
		if (cnt == n / 2) {
			long vx = 0;
			long vy = 0;
			int idx = 0;
			for (int i = 0; i < n; i++) {
				if (!visit[i]) {
					int x1 = halfWorms.get(idx)[0];
					int y1 = halfWorms.get(idx)[1];
					int x2 = worms.get(i)[0];
					int y2 = worms.get(i)[1];
					vx += (x2 - x1);
					vy += (y2 - y1);
					idx++;
				}
			}
			long dist = (vx * vx) + (vy * vy);
			answer = Math.min(answer, dist);
			return;
		}
		for (int i = next; i < n; i++) {
			if (!visit[next]) {
				visit[i] = true;
				halfWorms.add(worms.get(i));
				dfs(i + 1, cnt + 1);
				visit[i] = false;
				halfWorms.remove(worms.get(i));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1494.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());

			worms = new ArrayList<>();
			halfWorms = new ArrayList<>();
			visit = new boolean[n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				worms.add(new int[] { a, b });
			}
			answer = Long.MAX_VALUE;
			dfs(0, 0);
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
