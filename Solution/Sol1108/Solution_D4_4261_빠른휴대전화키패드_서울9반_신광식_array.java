package boj.Sol1108;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution_D4_4261_빠른휴대전화키패드_서울9반_신광식_array {
	static char[][] keypad = { {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
			{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' }, };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_4261.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
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

				// 키패드와 일치하는 문자 개수
				int cnt = 0;
				for (int j = 0; j < s.length(); j++) {
					// 키패드 번호, 현재 단어의 문자
					int keypadIdx = s.charAt(j) - '0' - 1;
					char compChar = str.charAt(j);
					for (int k = 0; k < keypad[keypadIdx].length; k++) {
						// 키패드 번호에 속한 문자가 현재 단어와 일치 하면 문자 수 증가
						if (keypad[keypadIdx][k] == compChar) {
							cnt++;
							break;
						}
					}
				}
				if (cnt == str.length())
					answer++;
			}
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
