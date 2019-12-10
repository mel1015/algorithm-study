package boj.Sol1108;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution_D4_4261_빠른휴대전화키패드_서울9반_신광식_hashmap {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_4261.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		HashMap<Character, Integer> hm = new HashMap<>();
		char alpa = 'a';
		for (int i = 2; i < 10; i++) {
			int cnt = 3;
			if (i == 7 || i == 9)
				cnt = 4;
			for (int j = 0; j < cnt; j++) {
				hm.put(alpa++, i);
			}
		}
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int answer = 0;
			for (int i = 0; i < n; i++) {
				String str = st.nextToken();
				// 입력된 단어 길이와 누른 키패드 횟수가 다르면 continue
				if (str.length() != s.length())
					continue;

				int cnt = 0;
				for (int j = 0; j < s.length(); j++) {
					int keypadIdx = s.charAt(j) - '0';
					char compChar = str.charAt(j);
					if (hm.get(compChar) == keypadIdx)
						cnt++;
					else
						break;
				}
				if (cnt == str.length())
					answer++;
			}
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
