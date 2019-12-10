package boj.Sol1031;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Solution_D9_5658_보물상자비밀번호_서울9반_신광식 {
	static int n, k;
	static String str;
	static ArrayList<Integer> password;

	static void rotate() {
		StringBuilder sb = new StringBuilder(str);
		for (int roll = 0; roll < n / 4; roll++) {
			int from = 0;
			int to = n / 4;
			for (int i = 0; i < 4; i++) {
				String substr = sb.substring(from, to);
				int val = Integer.valueOf(substr, 16) * -1;
				if (!password.contains(val))
					password.add(val);
				from = to;
				to += n / 4;
			}
			sb.insert(0, sb.charAt(sb.length() - 1));
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d9_5658.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			password = new ArrayList<>();
			str = br.readLine();
			rotate();
			Collections.sort(password);
			System.out.println("#" + tc + " " + password.get(k - 1) * -1);
		}
		br.close();
	}

}
