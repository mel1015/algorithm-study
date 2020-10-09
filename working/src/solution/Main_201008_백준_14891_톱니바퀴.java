package solution;

import java.io.*;
import java.util.*;

public class Main_201008_백준_14891_톱니바퀴 {
	static String[] gears;
	static boolean[] rotate;
	static int k;

	static void gearRotate(int num, int dir) {
		// gears : 2번이 오른쪽, 6번이 왼쪽
		int left = num - 1;
		int right = num + 1;
		rotate[num] = true;

		// 좌우의 톱니바퀴 회전
		if (left >= 1 && !rotate[left] && gears[num].charAt(6) != gears[left].charAt(2)) {
			gearRotate(left, dir * -1);
		}
		if (right <= 4 && !rotate[right] && gears[num].charAt(2) != gears[right].charAt(6)) {
			gearRotate(right, dir * -1);
		}

		// 현재 톱니바퀴 회전
		StringBuilder sb = new StringBuilder(gears[num]);
		if (dir == 1) {
			// 시계방향 => 0->1, 1->2, 2->3, ..., 7->0
			sb.insert(0, sb.charAt(7));
			sb.deleteCharAt(8);
		} else {
			sb.insert(8, sb.charAt(0));
			sb.deleteCharAt(0);
		}
		gears[num] = sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		gears = new String[5];
		rotate = new boolean[5];
		for (int i = 1; i < 5; i++) {
			gears[i] = br.readLine();
		}

		k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			gearRotate(num, dir);
			Arrays.fill(rotate, false);
		}

		int answer = 0;
		int score = 1;
		for (int i = 1; i < 5; i++) {
			if (gears[i].charAt(0) == '1') {
				answer += score;
			}
			score *= 2;
		}
		System.out.println(answer);

		br.close();
	}
}