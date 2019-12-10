package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3074_입국심사_서울9반_신광식 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_3074.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] time = new int[n];
			long maxTime = 0;
			for (int i = 0; i < n; i++) {
				time[i] = Integer.parseInt(br.readLine());
				maxTime = Math.max(maxTime, time[i]);
			}
			// left: 최소 심사 시간, right: 최대 심사시간
			long left = 0;
			long right = maxTime * m;
			long mid = 0, answer = 0;
			while (left <= right) {
				// passCnt: mid시간으로 검사할 수 있는 최대 인원
				mid = (left + right) / 2;
				long passCnt = 0;
				for (int i = 0; i < n; i++) {
					passCnt += mid / time[i];
				}
				if (passCnt < m)
					// 최대 인원이 m명보다 작다 => 시간이 부족하다
					left = mid + 1;
				else {
					// 최대 인원이 m명보다 크거나 같다 => 시간이 적절하다
					answer = mid;
					right = mid - 1;
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}