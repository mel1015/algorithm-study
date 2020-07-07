package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_200703_백준_19238_스타트택시3 {
	static int[][] direct = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
	static int[][] map;
	static int[][] startingPoint;
	static Map<Integer, Pos> destination = new LinkedHashMap<>();
	static int N, M, fuel;
	static Pos taxi;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());

		map = new int[N + 2][N + 2]; // 가장자리는 1
		Arrays.fill(map[0], 1);
		Arrays.fill(map[N + 1], 1);
		for (int i = 1; i <= N; i++) {
			map[i][0] = map[i][N + 1] = 1;
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		taxi = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

		startingPoint = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			startingPoint[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = i + 1;
			destination.put(i + 1, new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		// solve
		while (destination.size() > 0) {
			if (!move()) {
				fuel = -1;
				break;
			}
//            System.out.println("turn " + destination.size() + ": " + fuel);
		}

		System.out.print(fuel);
	}

	private static boolean move() {
		int customer = findClosestCustomer();
		if (fuel < 0 || customer == 0)
			return false;
		int distToDestination = findDistanceToDestination(customer, destination.get(customer));
		if (fuel < 0)
			return false;
		fuel += distToDestination * 2;
		return true;
	}

	private static int findDistanceToDestination(int customer, Pos dest) {
		if (dest.x == taxi.x && dest.y == taxi.y) {
			destination.remove(customer);
			return 0;
		}

		boolean[][] visited = new boolean[N + 1][N + 1];
		Queue<Pos> q = new LinkedList<>();
		q.offer(taxi);
		int dist = 0;
		while (!q.isEmpty()) {
			dist++;
			for (int q_size = q.size(); q_size > 0; q_size--) {
				int x = q.peek().x, y = q.poll().y;
				for (int i = 0; i < 4; i++) {
					int nx = x + direct[i][0], ny = y + direct[i][1];
					if (map[nx][ny] == 1 || visited[nx][ny])
						continue;
					if (nx == dest.x && ny == dest.y) {
						destination.remove(customer);
						fuel -= dist;
						taxi.x = dest.x;
						taxi.y = dest.y;
						return dist;
					}
					visited[nx][ny] = true;
					q.offer(new Pos(nx, ny));
				}
			}
		}
		return 0;
	}

	private static int findClosestCustomer() {
		if (startingPoint[taxi.x][taxi.y] != 0) {// 택시 위치에 손님이 있을 경우
			int c = startingPoint[taxi.x][taxi.y];
			startingPoint[taxi.x][taxi.y] = 0;
			return c;
		}

		boolean[][] visited = new boolean[N + 1][N + 1];
		Queue<Pos> q = new LinkedList<>();
		q.offer(taxi);
		int customer = 0, distToStartingPoint = 0;
		int cx = 0, cy = 0;
		while (!q.isEmpty()) {
			distToStartingPoint++;
			for (int q_size = q.size(); q_size > 0; q_size--) {
				int x = q.peek().x, y = q.poll().y;
				for (int i = 0; i < 4; i++) {
					int nx = x + direct[i][0], ny = y + direct[i][1];
					if (map[nx][ny] == 1 || visited[nx][ny])
						continue;
					if (startingPoint[nx][ny] != 0) {
						if (customer == 0) {
							customer = startingPoint[nx][ny];
							cx = nx;
							cy = ny;
						} else { // 같은 거리에 손님이 여러명
							if (cx > nx || (cx == nx && cy > ny)) { // 행 번호가 더 작거나, 행 번호는 같고 열 번호가 작으면 갱신
								customer = startingPoint[nx][ny];
								cx = nx;
								cy = ny;
							}
						}
					}
					visited[nx][ny] = true;
					q.offer(new Pos(nx, ny));
				}
			}
			if (customer != 0) {
				taxi.x = cx;
				taxi.y = cy;
				fuel -= distToStartingPoint;
				startingPoint[cx][cy] = 0;
				return customer;
			}
		}
		return 0;
	}

	private static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}