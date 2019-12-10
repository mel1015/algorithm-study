package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_15686_치킨배달_서울9반_신광식 {
	public static int n, m, answer;
	public static int[][] map;
	public static boolean[] visit;
	public static ArrayList<int[]> chicken, home, notClosed;

	public static void dfs(int x, int cnt) {
		if (cnt == m) {
			int sumDist = 0;
			for (int i = 0; i < home.size(); i++) {
				int minDist = Integer.MAX_VALUE;
				for (int j = 0; j < notClosed.size(); j++) {
					int dist = Math.abs(home.get(i)[0] - notClosed.get(j)[0])
							+ Math.abs(home.get(i)[1] - notClosed.get(j)[1]);
					minDist = Math.min(minDist, dist);
				}
				sumDist += minDist;
			}
			answer = Math.min(answer, sumDist);
			return;
		}
		for (int i = x; i < chicken.size(); i++) {
			visit[i] = true;
			notClosed.add(chicken.get(i));
			dfs(i + 1, cnt + 1);
			visit[i] = false;
			notClosed.remove(chicken.get(i));
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		chicken = new ArrayList<>();
		home = new ArrayList<>();
		notClosed = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					chicken.add(new int[] { i, j });
				else if (map[i][j] == 1) {
					home.add(new int[] { i, j });
				}
			}
		}
		answer = Integer.MAX_VALUE;
		visit = new boolean[chicken.size()];
		dfs(0, 0);
		System.out.println(answer);
		br.close();
	}

}
