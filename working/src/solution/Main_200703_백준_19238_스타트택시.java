package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_200703_백준_19238_스타트택시 {
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

	static void getDistance(Pos from) {
		Queue<Pos> q = new LinkedList<>();
		q.offer(from);

		for (int i = 1; i <= n; i++) {
			Arrays.fill(distMap[i], -1);
		}

		distMap[from.x][from.y] = 0;

		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.poll().y;
			for (int d = 0; d < dx.length; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && map[nx][ny] == 0 && distMap[nx][ny] == -1) {
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
		passenger = new Pos[m];
		destination = new Pos[m];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		taxi = new Pos(x, y);
		map[x][y] = -1;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			passenger[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			destination[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		while (true) {
			if (success == m)
				break;
			else if (fuel <= 0) {
				fuel = -1;
				break;
			}

			// 가장 가까운 승객 찾기
			getDistance(taxi);
			map[x][y] = 0;

			int minNum = -1;
			int minDist = Integer.MAX_VALUE;
			for (int i = 0; i < passenger.length; i++) {
				if (passenger[i] == null)
					continue;
				x = passenger[i].x;
				y = passenger[i].y;
				if (distMap[x][y] >= 0 && distMap[x][y] < minDist) {
					minDist = distMap[x][y];
					minNum = i;
				} else if (distMap[x][y] >= 0 && distMap[x][y] == minDist) {
					if (passenger[minNum].x == x) {
						minNum = (passenger[minNum].y > y) ? i : minNum;
					} else {
						minNum = (passenger[minNum].x > x) ? i : minNum;
					}
				} else if (distMap[x][y] < 0) {
					System.out.println(-1);
					System.exit(0);
				}
			}

			// 가장 가까운 승객의 위치까지 걸리는 연료
			x = passenger[minNum].x;
			y = passenger[minNum].y;
			map[x][y] = -1;
			int toPassengerFuel = distMap[x][y];
//			System.out.println(minNum + 1 + "번 승객까지 이동, 사용 연료 = " + toPassengerFuel);
//			printMap();

			// 승객의 위치에서 목적지까지의 거리 계산
			getDistance(passenger[minNum]);

			// 승객의 목적지까지 걸리는 연료
			map[x][y] = 0;
			x = destination[minNum].x;
			y = destination[minNum].y;
			map[x][y] = -1;
			int toDestinationFuel = distMap[x][y];
//			System.out.println(minNum + 1 + "승객의 목적지까지 이동, 사용 연료 = " + toDestinationFuel);
//			printMap();

			// 연료 계산, 택시 위치를 승객의 목적지로 변경
			if (fuel - (toPassengerFuel + toDestinationFuel) >= 0) {
				success++;
				passenger[minNum] = null;
				destination[minNum] = null;
				fuel -= (toPassengerFuel + toDestinationFuel);
				fuel += toDestinationFuel * 2;
				taxi.x = x;
				taxi.y = y;
//				System.out.println("택시 위치 = " + taxi + ", 남은 연료 = " + fuel);
			} else {
				fuel = -1;
				break;
			}
		}
		System.out.println(fuel);

		br.close();
	}

}
