package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1284_수도요금경쟁_서울9반_신광식 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int priceA = w * p;
			int pirceB = w <= r ? q : q + (w - r) * s;
			int answer = Math.min(priceA, pirceB);

			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
