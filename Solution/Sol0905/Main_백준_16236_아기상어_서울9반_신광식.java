package boj.Sol1017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_16236_아기상어_서울9반_신광식 {
	public static int n;
	public static Fish[][] map;
	public static int[][] dist;
	public static boolean[][] visit;
	public static Fish shark;
	public static ArrayList<Fish> fishes;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	static class Fish implements Comparable<Fish> {
		int x;
		int y;
		int size;
		int eat;

		public Fish(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}

		@Override
		public int compareTo(Fish o) {
			return Integer.compare(size, o.size);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		map = new Fish[n][n];
		dist = new int[n][n];
		visit = new boolean[n][n];
		fishes = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int data = Integer.parseInt(st.nextToken());
				Fish fish = new Fish(i, j, data);
				if (data == 9) {
					shark = new Fish(i, j, 2);
					fish.size = 0;
				} else if (data > 0) {
					fishes.add(fish);
				}
				map[i][j] = fish;
			}
		}
		int time = 0;
		while (!fishes.isEmpty()) {
			Collections.sort(fishes);
			if (fishes.get(0).size >= shark.size)
				break;

			Queue<Fish> q = new LinkedList<>();
			ArrayList<Fish> killList = new ArrayList<>();
			q.offer(shark);
			visit[shark.x][shark.y] = true;
			while (!q.isEmpty()) {
				Fish curr = q.poll();
				if (map[curr.x][curr.y].size != 0 && map[curr.x][curr.y].size < shark.size) {
					killList.add(curr);
				}
				for (int d = 0; d < 4; d++) {
					int nx = curr.x + dx[d];
					int ny = curr.y + dy[d];
					if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visit[nx][ny] && map[nx][ny].size <= shark.size) {
						q.offer(map[nx][ny]);
						dist[nx][ny] = dist[curr.x][curr.y] + 1;
						visit[nx][ny] = true;
					}
				}
			}
			if (killList.isEmpty())
				break;
			else {
				Collections.sort(killList, new Comparator<Fish>() {
					@Override
					public int compare(Fish o1, Fish o2) {
						if (dist[o1.x][o1.y] == dist[o2.x][o2.y]) {
							if (o1.x == o2.x) {
								return Integer.compare(o1.y, o2.y);
							} else
								return Integer.compare(o1.x, o2.x);
						} else
							return Integer.compare(dist[o1.x][o1.y], dist[o2.x][o2.y]);
					}
				});
				time += dist[killList.get(0).x][killList.get(0).y];
				shark.eat++;
				if (shark.eat == shark.size) {
					shark.eat = 0;
					shark.size++;
				}
				map[killList.get(0).x][killList.get(0).y] = new Fish(killList.get(0).x, killList.get(0).y, 0);
				shark.x = killList.get(0).x;
				shark.y = killList.get(0).y;
				for (int i = 0; i < n; i++) {
					Arrays.fill(dist[i], 0);
					Arrays.fill(visit[i], false);
				}
			}
		}
		System.out.println(time);
		br.close();
	}

}
