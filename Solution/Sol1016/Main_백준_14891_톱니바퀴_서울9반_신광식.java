package boj.Sol1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_14891_톱니바퀴_서울9반_신광식 {
	static int k, answer;
	static String[] gear;
	static boolean[] visit;

	static void gearSpin(int num, int dir) {
		// 방문 처리
		visit[num] = true;

		// 우측 톱니바퀴 돌리기
		if (num + 1 <= 3 && !visit[num + 1] && gear[num].charAt(2) != gear[num + 1].charAt(6))
			gearSpin(num + 1, dir * -1);
		// 좌측 톱니바퀴 돌리기
		if (num - 1 >= 0 && !visit[num - 1] && gear[num].charAt(6) != gear[num - 1].charAt(2))
			gearSpin(num - 1, dir * -1);

		// 현재 톱니바퀴 회전
		StringBuilder sb = new StringBuilder(gear[num]);
		if (dir == 1) {
			sb.insert(0, gear[num].charAt(gear[num].length() - 1));
			sb.deleteCharAt(sb.length() - 1);
			gear[num] = sb.toString();
		} else {
			sb.deleteCharAt(0);
			sb.append(gear[num].charAt(0));
			gear[num] = sb.toString();
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		gear = new String[4];
		visit = new boolean[4];
		for (int i = 0; i < 4; i++) {
			gear[i] = br.readLine();
		}
		k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			gearSpin(num, dir);
			Arrays.fill(visit, false);
		}
		int score = 1;
		for (int i = 0; i < 4; i++) {
			if (gear[i].charAt(0) == '1')
				answer += score;
			score *= 2;
		}
		System.out.println(answer);
	}

}
