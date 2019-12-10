package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1234_비밀번호_서울9반_신광식 {

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1234.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			String pw = st.nextToken();
			StringBuilder sb = new StringBuilder();
			sb.append(pw.charAt(0));
			for (int i = 1; i < size; i++) {
				if (sb.length() > 0 && sb.charAt(sb.length() - 1) == pw.charAt(i)) {
					sb.delete(sb.length() - 1, sb.length());
				} else {
					sb.append(pw.charAt(i));
				}
			}
			System.out.println("#" + tc + " " + sb);
		}
	}

}
