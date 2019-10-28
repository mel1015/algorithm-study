package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_D4_1258_행렬찾기_서울9반_신광식 {
	public static int n;
	public static int[][] map;
	public static ArrayList<int[]> box;
	public static StringBuilder sb;

	public static void solution() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int height = 0, width = 0;
				if (map[i][j] != 0) {
					int row = i;
					while (map[row][j] > 0) {
						height++;
						row++;
					}
					int col = j;
					while (map[i][col] > 0) {
						width++;
						col++;
					}
					for (int k = 0; k < height; k++) {
						for (int l = 0; l < width; l++) {
							map[i + k][j + l] = 0;
						}
					}
					j = col;
					box.add(new int[] { height, width });
				}
			}
		}
		sb.append(box.size() + " ");
		Collections.sort(box, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int size1 = o1[0] * o1[1];
				int size2 = o2[0] * o2[1];
				if (size1 == size2) {
					return Integer.compare(o1[0], o2[0]);
				} else {
					return Integer.compare(size1, size2);
				}
			}
		});
		for (int i = 0; i < box.size(); i++) {
			sb.append(box.get(i)[0] + " " + box.get(i)[1] + " ");
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1258.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			box = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sb = new StringBuilder("#" + tc + " ");
			solution();
			System.out.println(sb);
		}
		br.close();
	}

}