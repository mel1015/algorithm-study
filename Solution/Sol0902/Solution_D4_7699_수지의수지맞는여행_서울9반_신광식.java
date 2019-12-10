package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_D4_7699_수지의수지맞는여행_서울9반_신광식 {
	public static int r, c, answer;
	public static char[][] map;
	public static ArrayList<Character> saw;
	public static boolean[][] visit;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static boolean checkSaw(char a) {
		boolean isSaw = false;
		for (int i = 0; i < saw.size(); i++) {
			if (a == saw.get(i)) {
				isSaw = true;
				break;
			}
		}
		return isSaw;
	}

	public static void dfs(int x, int y) {
		visit[x][y] = true;
		saw.add(map[x][y]);
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || nx >= r || ny < 0 || ny >= c || visit[nx][ny] || checkSaw(map[nx][ny]))
				continue;
			dfs(nx, ny);
		}
		answer = Math.max(answer, saw.size());
		visit[x][y] = false;
		saw.remove(saw.size() - 1);
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_7699.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			answer = 0;
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			map = new char[r][c];
			visit = new boolean[r][c];
			saw = new ArrayList<>();
			for (int i = 0; i < r; i++) {
				String line = br.readLine();
				map[i] = line.toCharArray();
			}
			dfs(0, 0);
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
