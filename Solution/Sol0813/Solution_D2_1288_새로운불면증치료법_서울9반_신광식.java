package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Solution_D2_1288_새로운불면증치료법_서울9반_신광식 {

	public static int countSheep(String n) {
		TreeSet<Character> set = new TreeSet<>();
		int count = 1;
		String nn = n;
		while (true) {
			for (int i = 0; i < nn.length(); i++) {
				set.add(nn.charAt(i));
				if (set.size() == 10)
					return count;
			}
			nn = Integer.toString((Integer.parseInt(n) * ++count));
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String N = br.readLine();
			int answer = countSheep(N);
			System.out.println("#" + tc + " " + answer * Integer.parseInt(N));
		}
		br.close();
	}

}
