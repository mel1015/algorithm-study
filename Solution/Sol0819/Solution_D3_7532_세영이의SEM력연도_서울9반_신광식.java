package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 3. client program(main 메소드를 가진 객체)


public class Solution_D3_7532_세영이의SEM력연도_서울9반_신광식 {
	public static int answer = 0;

	public static void sem(int s, int e, int m) {
		int ns = e, nm = e;
		answer = e;
		if (ns == s && nm == m) {
			return;
		}
		
		int eMax = 24;
		while (true) {
			if (ns == s && nm == m) {
				break;
			}
			ns += eMax;
			if (ns > 365)
				ns %= 365;
			nm += eMax;
			if (nm > 29)
				nm %= 29;
			answer += eMax;
		}

	}

	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/input_d3_5431.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			answer = 0;
			sem(s, e, m);
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
