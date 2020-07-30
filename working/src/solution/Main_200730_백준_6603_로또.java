package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_200730_백준_6603_로또 {
	static int k, r = 6;
	static int[] s, comb, visit;

	static void combination(int start, int count) {
		if (count == r) {
			for (int i = 0; i < r; i++) {
				System.out.print(comb[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < k; i++) {
			if (visit[i] == 0) {
				visit[i] = 1;
				comb[count] = s[i];
				combination(i, count + 1);
				visit[i] = 0;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			String input = br.readLine();
			if (input.equals("0"))
				break;

			st = new StringTokenizer(input);
			k = Integer.parseInt(st.nextToken());
			s = new int[k];
			comb = new int[r];
			visit = new int[k];

			for (int i = 0; i < k; i++) {
				s[i] = Integer.parseInt(st.nextToken());
			}

			combination(0, 0);
			System.out.println();
		}
		br.close();
	}
}