package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_201017_백준_14503_로봇청소기 {
	static int n, m, robotX, robotY, robotDir, answer;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		robotX = Integer.parseInt(st.nextToken());
		robotY = Integer.parseInt(st.nextToken());
		robotDir = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;
		int mapData = -1;
		boolean end = false;
		while (!end) {
			// 청소하지 않은 공간 치우기 
			if (map[robotX][robotY] == 0) {
				map[robotX][robotY] = mapData;
				answer++;
				mapData--;
			}

			// 현재 방향을 기준으로 반시계로 먼지 찾기
			boolean findDust = false;
			int nextDir = robotDir;
			for (int d = 1; d <= 4; d++) {
				nextDir--;
				if (nextDir < 0) {
					nextDir = 3;
				}
				int nx = robotX + dx[nextDir];
				int ny = robotY + dy[nextDir];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if (map[nx][ny] == 0) {
						robotX = nx;
						robotY = ny;
						robotDir = nextDir;
						findDust = true;
						break;
					}
				}
			}

			// 먼지를 찾은 경우 1번으로
			// 찾지 못한 경우 후진, 후진도 못한다면 종료
			if (findDust) {
				continue;
			} else {
				nextDir = (robotDir + 2) % 4;
				int nx = robotX + dx[nextDir];
				int ny = robotY + dy[nextDir];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if (map[nx][ny] == 1) {
						end = true;
						break;
					} else {
						robotX = nx;
						robotY = ny;
					}
				}
			}
		}
		System.out.println(answer);
		br.close();
	}

}
