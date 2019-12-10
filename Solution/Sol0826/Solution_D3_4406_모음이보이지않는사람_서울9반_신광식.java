package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_4406_모음이보이지않는사람_서울9반_신광식 {
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_4406.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String answer = "";
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, "a|e|i|o|u");
			while (st.hasMoreTokens()) {
				answer += st.nextToken();
			}
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
