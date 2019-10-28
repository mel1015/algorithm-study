package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_3055_탈출_서울9반_신광식 {
	static int r, c, homeR, homeC;
	static char[][] map;
	static int[][] hMap, wMap;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void bfs(Queue<int[]> q, int[][] pMap) {
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int d = 0; d < dx.length; d++) {
				int nx = curr[0] + dx[d];
				int ny = curr[1] + dy[d];
				if (nx >= 0 && nx < r && ny >= 0 && ny < c && pMap[nx][ny] == Integer.MAX_VALUE && map[nx][ny] == '.') {
					pMap[nx][ny] = pMap[curr[0]][curr[1]] + 1;
					q.offer(new int[] { nx, ny });
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		hMap = new int[r][c];
		wMap = new int[r][c];
		Queue<int[]> q = new LinkedList<>();
		Queue<int[]> waterQ = new LinkedList<>();

		for (int i = 0; i < r; i++) {
			// map 입력, hMap & wMap 초기화
			map[i] = br.readLine().toCharArray();
			Arrays.fill(hMap[i], Integer.MAX_VALUE);
			Arrays.fill(wMap[i], Integer.MAX_VALUE);
			for (int j = 0; j < c; j++) {
				if (map[i][j] == 'S') {
					// 고슴도치 위치
					// 이동가능한 위치로 바꾸고, 고슴도치 지도에서 시작점(1초)으로 변경
					map[i][j] = '.';
					hMap[i][j] = 1;
					q.offer(new int[] { i, j });
				} else if (map[i][j] == 'D') {
					// 도착점
					homeR = i;
					homeC = j;
				} else if (map[i][j] == '*') {
					// 물의 위치
					// 물 지도에서 시작점(1초)으로 변경
					wMap[i][j] = 1;
					waterQ.offer(new int[] { i, j });
				}
			}
		}

		// 고슴도치 지도, 물 지도 BFS 탐색
		bfs(q, hMap);
		bfs(waterQ, wMap);

		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < dx.length; i++) {
			// 도착점의 4방향 중에 고슴도치가 먼저 도착한 곳이 있으면 피신 성공
			int nx = homeR + dx[i];
			int ny = homeC + dy[i];
			if (nx >= 0 && nx < r && ny >= 0 && ny < c && hMap[nx][ny] < wMap[nx][ny]) {
				answer = Math.min(answer, hMap[nx][ny]);
			}
		}
		System.out.println((answer == Integer.MAX_VALUE) ? "KAKTUS" : answer);
		br.close();
	}

}
