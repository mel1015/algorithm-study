package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_16917_양념반후라이드반_200224 {
	static int a, b, c, x, y;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());

		int answer = 0;
		if (2 * c <= a + b) {
			int onlyC = 0;
			if (x > y) {
				answer += (2 * c) * y;
				answer += a * (x - y);
				onlyC = (2 * c) * x;
			} else {
				answer += (2 * c) * x;
				answer += b * (y - x);
				onlyC = (2 * c) * y;
			}
			answer = Math.min(answer, onlyC);
		} else {
			answer += a * x + b * y;
		}
		System.out.println(answer);
		br.close();
	}

}
