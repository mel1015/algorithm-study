package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_17472_다리만들기2_서울9반_신광식 {
	static int n, m, island, answer;
	static int[][] map, islandMap, dist;
	static ArrayList<int[]> makeBridge;
	static ArrayList<int[]>[] posIsland;
	static boolean[] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// 범위 체크
	static boolean rangeCheck(int nx, int ny) {
		if (nx >= 0 && nx < n && ny >= 0 && ny < m)
			return true;
		return false;
	}

	// 섬을 찾고, 섬들의 번호를 매길 BFS
	static void islandBFS(int x, int y, int cnt) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		islandMap[x][y] = cnt + 1;
		posIsland[cnt].add(new int[] { x, y });
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int i = 0; i < dx.length; i++) {
				int nx = curr[0] + dx[i];
				int ny = curr[1] + dy[i];
				if (rangeCheck(nx, ny) && islandMap[nx][ny] == 0 && map[nx][ny] == 1) {
					q.offer(new int[] { nx, ny });
					islandMap[nx][ny] = cnt + 1;
					posIsland[cnt].add(new int[] { nx, ny });
				}
			}
		}
	}

	// 모든 섬의 칸으로부터 상하좌우로 다리를 놓아보고
	// 섬과 연결되면 인접행렬에 다리 길이를 갱신해줌
	static void buildBridge(int from) {
		for (int i = 0; i < posIsland[from].size(); i++) {
			int x = posIsland[from].get(i)[0];
			int y = posIsland[from].get(i)[1];
			for (int d = 0; d < dx.length; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (rangeCheck(nx, ny) && map[nx][ny] == 0) {
					int bridgeSize = 0;
					while (true) {
						nx += dx[d];
						ny += dy[d];
						bridgeSize++;
						if (!rangeCheck(nx, ny))
							break;
						else if (islandMap[nx][ny] != 0) {
							int to = islandMap[nx][ny] - 1;
							if (bridgeSize >= 2) {
								if (dist[from][to] > bridgeSize) {
									dist[from][to] = bridgeSize;
									dist[to][from] = bridgeSize;
								}
							}
							break;
						}
					}
				}
			}
		}
	}

	// 가능한 모든 조합으로 섬끼리 다리를 놓아봄
	// 다리를 놓을 수 있고 길이가 2이상이면 리스트에 저장
	static void findDistance() {
		for (int i = 0; i < island; i++) {
			buildBridge(i);
			for (int j = i + 1; j < island; j++) {
				if (dist[i][j] == Integer.MAX_VALUE)
					continue;
				makeBridge.add(new int[] { i, j });
			}
		}
	}

	// 섬들이 전부 연결되어있는지 확인
	static boolean isConnected() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] tmpVisit = new boolean[island];
		boolean[][] tmpConnect = new boolean[island][island];
		for (int i = 0; i < makeBridge.size(); i++) {
			int x = makeBridge.get(i)[0];
			int y = makeBridge.get(i)[1];
			if (visit[i]) {
				tmpConnect[x][y] = true;
				tmpConnect[y][x] = true;
			}
		}
		q.offer(0);
		tmpVisit[0] = true;
		int count = 1;
		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int i = 0; i < island; i++) {
				if (!tmpVisit[i] && tmpConnect[curr][i]) {
					tmpVisit[i] = true;
					q.offer(i);
					count++;
				}
			}
		}
		if (count == island)
			return true;
		return false;
	}

	// DFS로 만들 수 있는 모든 다리들의 조합을 구해
	// 모든 섬이 연결되면 
	static void distDFS(int start, int cnt, int maxBridge, int sum) {
		// start: 시작점, cnt: 현재 다리를 놓은 개수, maxBridge: 최대 다리 개수, sum: 다리 길이의 합
		if (cnt == maxBridge && isConnected()) {
			answer = Math.min(answer, sum);
			return;
		}
		for (int i = start; i < makeBridge.size(); i++) {
			if (!visit[i]) {
				visit[i] = true;
				distDFS(i, cnt + 1, maxBridge, sum + dist[makeBridge.get(i)[0]][makeBridge.get(i)[1]]);
				visit[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		islandMap = new int[n][m];
		makeBridge = new ArrayList<>();
		ArrayList<int[]> check = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			boolean isIsland = false;
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					isIsland = false;
				else if (!isIsland && map[i][j] == 1) {
					check.add(new int[] { i, j });
					isIsland = true;
				}
			}
		}

		posIsland = new ArrayList[6];
		for (int i = 0; i < posIsland.length; i++) {
			posIsland[i] = new ArrayList<>();
		}

		island = 0;
		for (int i = 0; i < check.size(); i++) {
			int x = check.get(i)[0];
			int y = check.get(i)[1];
			if (islandMap[x][y] == 0)
				islandBFS(x, y, island++);
		}

		dist = new int[island][island];
		for (int i = 0; i < dist.length; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}

		findDistance();

		visit = new boolean[makeBridge.size()];
		answer = Integer.MAX_VALUE;
		for (int i = island - 1; i <= island; i++) {
			distDFS(0, 0, i, 0);
		}
		System.out.println((answer == Integer.MAX_VALUE) ? -1 : answer);
		br.close();
	}

}
