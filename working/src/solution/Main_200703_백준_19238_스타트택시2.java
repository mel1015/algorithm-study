package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_200703_백준_19238_스타트택시2 {
	static int n, m, fuel, success;
	static Pos taxi;
	static int[][] map, distMap;
	static Pos[] passenger, destination;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "(" + x + "," + y + ")";
		}
	}

	static void printMap() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	static int getDistanceToPassenger() {
		if (map[taxi.x][taxi.y] != 0) {
			int passengerNum = map[taxi.x][taxi.y];
			map[taxi.x][taxi.y] = 0;
			return passengerNum;
		}

		Queue<Pos> q = new LinkedList<>();
		q.offer(taxi);

		distMap[taxi.x][taxi.y] = 0;
		int passengerNum = 0;
		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.poll().y;
			for (int d = 0; d < dx.length; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && map[nx][ny] != -1 && distMap[nx][ny] == -1) {
					if (map[nx][ny] != 0) {
						if (passengerNum == 0) {
							passengerNum = map[nx][ny];
						} else {
							int px = passenger[passengerNum].x;
							int py = passenger[passengerNum].y;
							if (distMap[px][py] == distMap[x][y] + 1) {
								if (px > nx || (px == nx && py > ny)) {
									passengerNum = map[nx][ny];
								}
							}
						}
					}
					distMap[nx][ny] = distMap[x][y] + 1;
					q.offer(new Pos(nx, ny));
				}
			}
		}
		if (passengerNum != 0) {
			taxi.x = passenger[passengerNum].x;
			taxi.y = passenger[passengerNum].y;
			fuel -= distMap[taxi.x][taxi.y];
			map[taxi.x][taxi.y] = 0;
		}
		return passengerNum;
	}

	static void getDistanceToDestination(int passengerNum) {
		Queue<Pos> q = new LinkedList<>();
		int px = passenger[passengerNum].x;
		int py = passenger[passengerNum].y;
		distMap[px][py] = 0;
		q.offer(passenger[passengerNum]);

		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.poll().y;
			if (x == destination[passengerNum].x && y == destination[passengerNum].y) {
				fuel -= distMap[x][y];
				if (fuel >= 0) {
					fuel += distMap[x][y] * 2;
					taxi.x = x;
					taxi.y = y;
					success++;
				}
				break;
			}
			for (int d = 0; d < dx.length; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && map[nx][ny] != -1 && distMap[nx][ny] == -1) {
					distMap[nx][ny] = distMap[x][y] + 1;
					q.offer(new Pos(nx, ny));
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());

		map = new int[n + 1][n + 1];
		distMap = new int[n + 1][n + 1];
		passenger = new Pos[m + 1];
		destination = new Pos[m + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				distMap[i][j] = -1;
				if (map[i][j] == 1)
					map[i][j] = -1;
			}
		}
		st = new StringTokenizer(br.readLine());
		taxi = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = i;
			passenger[i] = new Pos(x, y);
			destination[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		while (true) {
			if (success == m)
				break;
			else if (fuel < 0) {
				fuel = -1;
				break;
			}
			// 가장 가까운 승객 찾기
			int passengerNum = getDistanceToPassenger();
//			System.out.println("passenger = " + passengerNum + ", left fuel = " + fuel);
			for (int i = 1; i <= n; i++) {
				Arrays.fill(distMap[i], -1);
			}
			if (passengerNum == 0 || fuel < 0) {
				fuel = -1;
				break;
			}
			// 승객의 목적지까지 이동
			getDistanceToDestination(passengerNum);
//			System.out.println(passengerNum + " is arrived, left fuel = " + fuel);
			for (int i = 1; i <= n; i++) {
				Arrays.fill(distMap[i], -1);
			}
		}
		System.out.println(fuel);

		br.close();
	}

}
