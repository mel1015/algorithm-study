package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_5431_민석이의과제체크하기_서울9반_신광식 {

	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("res/input_d3_5431.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] arr = new int[n + 1];
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreElements()) {
				arr[Integer.parseInt(st.nextToken())]++;
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] == 0) {
					sb.append(i + " ");
				}
			}
			System.out.println("#" + tc + " " + sb);
		}
		br.close();
	}

}
