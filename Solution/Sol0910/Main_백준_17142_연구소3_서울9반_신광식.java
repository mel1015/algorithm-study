package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_17142_연구소3_서울9반_신광식 {
	public static int n, m, cntEmpty, answer;
	public static int[][] map, cpyMap;
	public static boolean[] visit;
	public static ArrayList<int[]> virus;
	public static Queue<int[]> q;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static int bfs() {
		int maxTime = 0, cnt = cntEmpty;
		for (int i = 0; i < visit.length; i++) {
			if (visit[i]) {
				q.offer(virus.get(i));
				cpyMap[virus.get(i)[0]][virus.get(i)[1]] = 0;
			}
		}
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int j = 0; j < 4; j++) {
				int nx = curr[0] + dx[j];
				int ny = curr[1] + dy[j];
				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;
				if (map[nx][ny] != 1 && cpyMap[nx][ny] == -1) {
					cpyMap[nx][ny] = cpyMap[curr[0]][curr[1]] + 1;
					if (map[nx][ny] == 0) {
						cnt--;
						maxTime = cpyMap[nx][ny];
					}
					q.offer(new int[] { nx, ny });
				}
			}
		}
		return (cnt == 0) ? maxTime : Integer.MAX_VALUE;
	}

	public static void combi(int start, int cnt) {
		if (cnt == m) {
			int maxTime = bfs();
			answer = Math.min(answer, maxTime);
			for (int i = 0; i < n; i++) {
				Arrays.fill(cpyMap[i], -1);
			}
			return;
		}
		for (int i = start; i < virus.size(); i++) {
			if (!visit[i]) {
				visit[i] = true;
				combi(i, cnt + 1);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		cpyMap = new int[n][n];
		virus = new ArrayList<>();
		q = new LinkedList<>();

		int vCnt = 0, wall = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				cpyMap[i][j] = -1;
				if (map[i][j] == 2) {
					virus.add(new int[] { i, j });
					vCnt++;
				} else if (map[i][j] == 1) {
					wall++;
				}
			}
		}
		cntEmpty = (n * n) - vCnt - wall;
		if (cntEmpty == 0) {
			answer = 0;
		} else {
			answer = Integer.MAX_VALUE;
			visit = new boolean[vCnt];
			combi(0, 0);
		}
		System.out.println((answer == Integer.MAX_VALUE) ? -1 : answer);

		br.close();
	}

}
