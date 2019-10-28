package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Solution_D3_7728_다양성측정_서울9반_신광식 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			TreeSet<Integer> ts = new TreeSet<>();
			while (n > 0) {
				ts.add(n % 10);
				n /= 10;
			}
			System.out.println("#" + tc + " " + ts.size());
		}
	}

}
