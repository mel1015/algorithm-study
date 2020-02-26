package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_200224_백준_16956_늑대와양 {
	static int r, c;
	static char[][] map;
	static ArrayList<int[]> sheeps;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		sheeps = new ArrayList<>();

		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				if (map[i][j] == 'S')
					sheeps.add(new int[] { i, j });
			}
		}

		int answer = 1;
		boolean sheepDie = false;
		for (int i = 0; i < sheeps.size() && !sheepDie; i++) {
			int x = sheeps.get(i)[0];
			int y = sheeps.get(i)[1];
			for (int d = 0; d < dx.length && !sheepDie; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
					if (map[nx][ny] == 'W') {
						answer = 0;
						sheepDie = true;
						break;
					} else if (map[nx][ny] == '.') {
						map[nx][ny] = 'D';
					}
				}
			}
		}
		System.out.println(answer);
		for (int i = 0; i < r && !sheepDie; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		br.close();
	}

}
