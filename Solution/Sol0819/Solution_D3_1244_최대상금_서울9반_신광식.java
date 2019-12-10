package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1244_최대상금_서울9반_신광식 {
	public static int n, answer;
	public static String num;

	public static char[] swap(String str, int i, int j) {
		char ch[] = str.toCharArray();
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
		return ch;
	}

	public static void dfs(int cur, int cnt) {
		if (cnt == n) {
			// num이 char 배열일 때 => Integer.parseInt(String.valueof(num));
			answer = Math.max(answer, Integer.parseInt(num));
			return;
		}
		for (int i = cur; i < num.length(); i++) {
			for (int j = i + 1; j < num.length(); j++) {
				if (num.charAt(i) <= num.charAt(j)) {
					num = new String(swap(num, i, j));
					dfs(i, cnt + 1);
					num = new String(swap(num, i, j));
				}
			}
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1244.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			num = st.nextToken();
			n = Integer.parseInt(st.nextToken());
			answer = 0;
			dfs(0, 0);
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}