package boj.Sol1017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_16234_인구이동_서울9반_신광식 {
	public static int n, l, r, answer;
	public static int[][] map;
	public static boolean[][] visit;
	public static Queue<ArrayList<int[]>> unions;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		visit = new boolean[n][n];
		unions = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<int[]> q = new LinkedList<>();
		int day = 0;
		while (true) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visit[i][j]) {
						ArrayList<int[]> temp = new ArrayList<>();
						q.offer(new int[] { i, j });
						visit[i][j] = true;
						while (!q.isEmpty()) {
							int[] curr = q.poll();
							temp.add(curr);
							int currPop = map[curr[0]][curr[1]];
							for (int d = 0; d < 4; d++) {
								int nx = curr[0] + dx[d];
								int ny = curr[1] + dy[d];
								if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny])
									continue;
								int nextPop = map[nx][ny];
								if (Math.abs(currPop - nextPop) >= l && Math.abs(currPop - nextPop) <= r) {
									visit[nx][ny] = true;
									q.add(new int[] { nx, ny });
								}
							}
						}
						if (temp.size() > 1)
							unions.offer(temp);
						else
							visit[i][j] = false;
					}
				}
			}
			if (unions.isEmpty())
				break;
			else {
				while (!unions.isEmpty()) {
					ArrayList<int[]> temp = unions.poll();
					int sum = 0;
					for (int j = 0; j < temp.size(); j++) {
						sum += map[temp.get(j)[0]][temp.get(j)[1]];
					}
					for (int j = 0; j < temp.size(); j++) {
						map[temp.get(j)[0]][temp.get(j)[1]] = sum / temp.size();
						visit[temp.get(j)[0]][temp.get(j)[1]] = false;
					}
				}
			}
			day++;
		}
		System.out.println(day);
		br.close();
	}

}
