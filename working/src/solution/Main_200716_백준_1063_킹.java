package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_200716_백준_1063_킹 {
	static int n;
	static int[] king, stone;
	static String[] dir = { "R", "L", "B", "T", "RT", "LT", "RB", "LB" };
	static int[] dx = { 0, 0, 1, -1, -1, -1, 1, 1 };
	static int[] dy = { 1, -1, 0, 0, 1, -1, 1, -1 };

	// String으로 입력된 좌표를 int[]로 변환
	static int[] changePos(String str) {
		int[] pos = new int[2];

		char col = str.charAt(0);
		char row = str.charAt(1);

		pos[1] = col - 'A';
		pos[0] = 8 - (row - '0');

		return pos;
	}

	// int[]로 입력된 좌표를 String으로 변환
	static String changePos(int[] arr) {
		String pos = "";

		int col = arr[1];
		int row = arr[0];

		char cc = (char) (col + 'A');
		pos += cc;
		int cr = 8 - row;
		pos += cr;

		return pos;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String kingStr = st.nextToken();
		king = changePos(kingStr);

		String stoneStr = st.nextToken();
		stone = changePos(stoneStr);
		n = Integer.parseInt(st.nextToken());

		loop: for (int i = 0; i < n; i++) {
			String d = br.readLine();
			for (int j = 0; j < dir.length; j++) {
				if (d.equals(dir[j])) {
					int nx = king[0] + dx[j];
					int ny = king[1] + dy[j];
					
					// 범위 체크 => 체스 판 밖으로 벗어나면 해당 이동 건너 뜀
					if (!(nx >= 0 && nx < 8 && ny >= 0 && ny < 8))
						continue loop;
					
					// 킹이 이동한 위치가 돌의 위치면
					// 돌의 위치는 킹과 같은 방향으로 한칸 전진
					// 킹의 위치는 돌의 기존 위치로 변경
					if (nx == stone[0] && ny == stone[1]) {
						nx += dx[j];
						ny += dy[j];
						if (!(nx >= 0 && nx < 8 && ny >= 0 && ny < 8))
							continue loop;
						stone[0] = nx;
						stone[1] = ny;
						nx -= dx[j];
						ny -= dy[j];
					}
					king[0] = nx;
					king[1] = ny;
					break;
				}
			}
		}
		System.out.println(changePos(king));
		System.out.println(changePos(stone));

		br.close();
	}
}