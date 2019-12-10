package d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D2_1986_지그재그숫자_서울9반_신광식 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int mul = 1, result = 0;
			for (int i = 1; i <= n; i++) {
				result += i * mul;
				mul *= -1;
			}
			System.out.println("#" + tc + " " + result);
		}
		br.close();
	}

}
