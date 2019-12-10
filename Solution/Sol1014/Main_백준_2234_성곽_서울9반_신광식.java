package boj.Sol1014;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_2234_성곽_서울9반_신광식 {
	static int n, m, maxRoom, cntRoom, sumRoom;
	static int[][] wall, map, adj;
	static HashMap<Integer, Integer> room;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static ArrayList<int[]> move(int x, int y) {
		ArrayList<int[]> pos = new ArrayList<>();
		String bs = Integer.toBinaryString(wall[x][y]);

		for (int i = 0; i < 4 - bs.length(); i++) {
			pos.add(new int[] { x + dx[i], y + dy[i] });
		}
		int idx = 0;
		for (int i = 4 - bs.length(); i < 4; i++) {
			if (bs.charAt(idx) == '0') {
				pos.add(new int[] { x + dx[i], y + dy[i] });
			}
			idx++;
		}
		return pos;
	}

	static int bfs(int i, int j, int num) {
		map[i][j] = num;
		if (wall[i][j] == 15)
			return 1;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { i, j });
		int cnt = 0;
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.poll()[1];
			cnt++;
			ArrayList<int[]> pos = move(x, y);
			for (int d = 0; d < pos.size(); d++) {
				int nx = pos.get(d)[0];
				int ny = pos.get(d)[1];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0) {
					map[nx][ny] = num;
					q.add(new int[] { nx, ny });
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		wall = new int[n][m];
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				wall[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		maxRoom = cntRoom = sumRoom = 0;
		room = new HashMap<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					int roomSize = bfs(i, j, ++cntRoom);
					maxRoom = Math.max(maxRoom, roomSize);
					room.put(cntRoom, roomSize);
				}
			}
		}
		adj = new int[room.size()][room.size()];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int d = 0; d < dx.length; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != map[i][j]) {
						adj[map[i][j] - 1][map[nx][ny] - 1] = 1;
						adj[map[nx][ny] - 1][map[i][j] - 1] = 1;
					}
				}
			}
		}

		for (int i = 0; i < room.size(); i++) {
			for (int j = i + 1; j < room.size(); j++) {
				if (adj[i][j] == 1) {
					sumRoom = Math.max(sumRoom, room.get(i + 1) + room.get(j + 1));
				}
			}
		}
		System.out.println(cntRoom);
		System.out.println(maxRoom);
		System.out.println(sumRoom);
		br.close();
	}

}
