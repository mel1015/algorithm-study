package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 기출_14502_신광식 {
	static int n, m, answer = 0;
	static int[][] map;
	static int[][] visit;
	static int[][] temp;
	static ArrayList<Virus> virusPos;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	// 바이러스의 좌표를 저장할 클래스
	static class Virus {
		int x;
		int y;

		public Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int virus() {
		// 기존의 map의 값을 변경할 수 없으므로 temp에 map을 딥카피
		for (int i = 0; i < map.length; i++) {
			System.arraycopy(map[i], 0, temp[i], 0, map[i].length);
		}
		// 저장해둔 각 바이러스의 위치부터 퍼져나가기 시작
		for (int i = 0; i < virusPos.size(); i++) {
			ArrayList<Virus> q = new ArrayList<>();
			q.add(virusPos.get(i));
			while (!q.isEmpty()) {
				Virus cur = q.get(0);
				q.remove(0);
				for (int j = 0; j < 4; j++) {
					int nx = cur.x + dx[j];
					int ny = cur.y + dy[j];
					if (nx >= 0 && nx < n && ny >= 0 && ny < m && temp[nx][ny] == 0) {
						temp[nx][ny] = 2;
						q.add(new Virus(nx, ny));
					}
				}
			}
		}
		// 안전 구역 세기
		int count = 0;
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				if (temp[i][j] == 0)
					count++;
			}
		}
		return count;
	}

	static void dfs(int x, int y, int cnt) {
		// 벽 세우고, 방문 표시
		map[x][y] = 1;
		visit[x][y] = 1;
		if (cnt == 3) {
			// 벽을 3개 세웠으면 바이러스를 퍼뜨리고 안전 구역 세기
			answer = Math.max(answer, virus());
			// 계산 후 초기화
			map[x][y] = 0;
			visit[x][y] = 0;
			return;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visit[i][j] == 0 && map[i][j] == 0) {
					dfs(i, j, cnt + 1);
				}
			}
		}
		// DFS 실행 후 초기화
		map[x][y] = 0;
		visit[x][y] = 0;
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new int[n][m];
		temp = new int[n][m];

		virusPos = new ArrayList<Virus>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					// 바이러스 위치 저장
					virusPos.add(new Virus(i, j));
				}
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 0) {
					// 모든 빈칸에 대해 DFS실행 => 모든 빈칸에 벽을 세워봄
					dfs(i, j, 1);
				}
			}
		}
		System.out.println(answer);

		br.close();
	}

}
