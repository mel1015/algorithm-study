package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D3_3499_퍼펙트셔플_서울9반_신광식 {

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_3499.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());

			String[] str = br.readLine().split(" ");
			System.out.print("#" + tc + " ");
			if (n % 2 == 0) {
				for (int i = 0; i < n / 2; i++) {
					System.out.print(str[i] + " " + str[n / 2 + i] + " ");
				}
				System.out.println();
			} else {
				for (int i = 0; i < n / 2; i++) {
					System.out.print(str[i] + " " + str[n / 2 + i + 1] + " ");
				}
				System.out.print(str[n / 2]);
				System.out.println();
			}
		}
		br.close();
	}

}
