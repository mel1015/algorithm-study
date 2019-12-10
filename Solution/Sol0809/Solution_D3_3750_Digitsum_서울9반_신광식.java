package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D3_3750_Digitsum_서울9반_신광식 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String n = br.readLine();
			while (n.length() > 1) {
				int sum = 0;
				for (int i = 0; i < n.length(); i++) {
					sum += n.charAt(i) - '0';
				}
				n = Integer.toString(sum);
			}
			System.out.println("#" + tc + " " + n);
		}
		br.close();
	}

}
