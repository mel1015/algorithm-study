package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_D3_1240_단순2진암호코드_서울9반_신광식 {
	public static int n, m, answer = 0;
	public static String[] password;
	public static String[] code = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111",
			"0111011", "0110111", "0001011" };

	private static void decryption(int row, int col) {
		int begin = col - 55;
		ArrayList<Integer> realPw = new ArrayList<>();

		while (begin < col) {
			String s = password[row].substring(begin, begin + 7);
			for (int i = 0; i < code.length; i++) {
				if (s.equals(code[i])) {
					realPw.add(i);
					break;
				}
			}
			begin += 7;
		}
		int validation = 0, result = 0;
		for (int i = 0; i < realPw.size(); ++i) {
			result += realPw.get(i);
			if ((i + 1) % 2 == 1) {
				validation += realPw.get(i) * 3;
			} else
				validation += realPw.get(i);
		}

		if (validation % 10 == 0) {
			answer = result;
			return;
		} else
			answer = 0;
		return;
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1240.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			password = new String[n];
			int row = 0, col = 0;
			for (int i = 0; i < n; i++) {
				password[i] = br.readLine();
				if (password[i].contains("1")) {
					row = i;
					col = password[i].lastIndexOf("1");
				}
			}
			answer = 0;
			decryption(row, col);
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
