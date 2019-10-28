package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_3307_최장증가부분수열_서울9반_신광식 {
	
	public static void main(String args[]) throws Exception {
//      System.setIn(new FileInputStream("res/input_d3_3307.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			int[] arr = new int[N];
			int[] countLength = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int answer = 0;
			for (int i = 0; i < N; i++) {
				int num = arr[i];
				int count = countLength[i];
				for (int j = i + 1; j < N; j++) {
					if (num > arr[j])
						continue;
					if (count + 1 <= countLength[j])
						continue;
					countLength[j] = count + 1;
					if (count + 1 > answer)
						answer = count + 1;
				}
			}
			System.out.println("#" + tc + " " + (answer + 1));
		}
		br.close();
	}
	
}