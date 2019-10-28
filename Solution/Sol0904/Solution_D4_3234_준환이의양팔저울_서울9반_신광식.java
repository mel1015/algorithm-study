package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_3234_준환이의양팔저울_서울9반_신광식 {
	public static int n;
	public static long answer;
	public static int[] weight;

	public static void perm(int step, int left, int right) {
		if (step == n)
			answer++;
		for (int i = step; i < n; i++) {
			int temp = weight[i];
			weight[i] = weight[step];
			weight[step] = temp;
			perm(step + 1, left + weight[step], right);
			if (right + weight[step] <= left)
				perm(step + 1, left, right + weight[step]);
			temp = weight[i];
			weight[i] = weight[step];
			weight[step] = temp;
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_3234.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			weight = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			answer = 0;
			perm(0, 0, 0);
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}