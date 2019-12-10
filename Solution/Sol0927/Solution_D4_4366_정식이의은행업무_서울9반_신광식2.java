package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_D4_4366_정식이의은행업무_서울9반_신광식2 {
	static long answer;

	static boolean check(char[] tetemp, ArrayList<Long> value) {
		long tVal = Long.valueOf(String.valueOf(tetemp), 3);
		if (value.contains(tVal)) {
			answer = tVal;
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_4366.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			answer = 0;
			char[] binary = br.readLine().toCharArray();
			char[] ternary = br.readLine().toCharArray();
			ArrayList<Long> value = new ArrayList<>();
			for (int i = 0; i < binary.length; i++) {
				char[] bitemp = binary.clone();
				if (bitemp[i] == '1')
					bitemp[i] = '0';
				else
					bitemp[i] = '1';
				value.add(Long.valueOf(String.valueOf(bitemp), 2));
			}
			loop: for (int i = 0; i < ternary.length; i++) {
				char[] tetemp = ternary.clone();
				for (int j = 0; j < 3; j++) {
					tetemp[i] = Integer.toString(j).charAt(0);
					if (check(tetemp, value))
						break loop;
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}