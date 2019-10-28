package boj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_17472_다리만들기2_서울9반_신광식_kruskal {
	static int n, m, island;
	static int[][] map, dist;
	static Queue<int[]> islandQ;
	static int[] p;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// 범위 체크
	static boolean rangeCheck(int nx, int ny) {
		if (nx >= 0 && nx < n && ny >= 0 && ny < m)
			return true;
		return false;
	}

	// 섬을 찾고, 섬들의 번호를 매길 BFS
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		map[x][y] = island;
		while (!q.isEmpty()) {
			int cx = q.peek()[0];
			int cy = q.poll()[1];
			for (int d = 0; d < dx.length; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				if (rangeCheck(nx, ny) && map[nx][ny] == -1) {
					if (map[nx][ny] == -1) {
						map[nx][ny] = island;
						q.add(new int[] { nx, ny });
						islandQ.add(new int[] { nx, ny, island });
					}
				}
			}
		}
	}

	// 모든 섬의 칸으로부터 상하좌우로 다리를 놓아보고
	// 섬과 연결되면 인접행렬에 다리 길이를 갱신해줌
	static void makeAdj() {
		while (!islandQ.isEmpty()) {
			int x = islandQ.peek()[0];
			int y = islandQ.peek()[1];
			int num = islandQ.poll()[2];
			for (int d = 0; d < dx.length; d++) {
				int nx = x;
				int ny = y;
				int bridgeLen = 0;
				while (true) {
					nx += dx[d];
					ny += dy[d];
					if (!rangeCheck(nx, ny) || map[nx][ny] == num)
						break;
					else if (map[nx][ny] == 0)
						bridgeLen++;
					else if (map[nx][ny] > 0 && bridgeLen >= 2) {
						dist[num - 1][map[nx][ny] - 1] = Math.min(dist[num - 1][map[nx][ny] - 1], bridgeLen);
						dist[map[nx][ny] - 1][num - 1] = Math.min(dist[map[nx][ny] - 1][num - 1], bridgeLen);
						break;
					} else
						break;
				}
			}
		}
	}

	public static int find(int x) {
		if (p[x] == x)
			return x;
		else
			return p[x] = find(p[x]);
	}

	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a < b)
			p[b] = a;
		else
			p[a] = b;
	}

	public static int kruskal() {
		// 연결된 다리들(간선)을 리스트에 넣어줌
		ArrayList<int[]> v = new ArrayList<int[]>();
		for (int i = 0; i < island; i++) {
			for (int j = 0; j < island; j++) {
				if (dist[i][j] != 987654321) {
					v.add(new int[] { i, j, dist[i][j] });
				}
			}
		}
		// 최소 길이의 다리부터 선택하기 위해 정렬
		Collections.sort(v, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});

		// Parent 배열 p set
		p = new int[island];
		for (int i = 0; i < island; i++) {
			p[i] = i;
		}

		// 다리 길이 총합, 만들어진 다리 개수
		int sum = 0, count = 0;
		for (int i = 0; i < v.size(); i++) {
			if (find(v.get(i)[0]) != find(v.get(i)[1])) {
				sum += v.get(i)[2];
				union(v.get(i)[0], v.get(i)[1]);
				count++;
			}
		}
		// 다리 개수가 n-1개 미만이면 => 모든 섬이 연결되지 않았음
		return (count >= island - 1) ? sum : 0;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_boj_17472.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 0; tc < 20; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			islandQ = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()) * -1;
				}
			}
			// 섬 찾고 번호매기기
			island = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == -1) {
						island++;
						islandQ.add(new int[] { i, j, island });
						bfs(i, j);
					}
				}
			}
			// 인접행렬 만들기
			dist = new int[island][island];
			for (int i = 0; i < dist.length; i++) {
				Arrays.fill(dist[i], 987654321);
			}
			makeAdj();
			// 크루스칼
			int answer = kruskal();
			System.out.println((answer == 0) ? -1 : answer);
		}
		br.close();
	}

}
