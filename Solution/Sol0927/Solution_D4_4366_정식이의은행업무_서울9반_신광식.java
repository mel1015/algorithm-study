package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D4_4366_정식이의은행업무_서울9반_신광식 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_4366.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String binary = br.readLine();
			String ternary = br.readLine();
			long bv = 0;
			long tv = 0;
			long answer = 0;
			loop: for (int i = 0; i < binary.length(); i++) {
				StringBuilder bsb = new StringBuilder(binary);
				for (int j = 0; j < 2; j++) {
					bsb.replace(i, i + 1, Integer.toString(j));
					bv = Long.valueOf(bsb.toString(), 2);
					for (int k = 0; k < ternary.length(); k++) {
						StringBuilder tsb = new StringBuilder(ternary);
						for (int l = 0; l < 3; l++) {
							tsb.replace(k, k + 1, Integer.toString(l));
							tv = Long.valueOf(tsb.toString(), 3);
							if (bv == tv) {
								answer = tv;
								break loop;
							}
						}
					}
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}