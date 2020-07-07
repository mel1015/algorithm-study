package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_200317_백준_13702_이상한술집 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] drink = new int[n];

		for (int i = 0; i < drink.length; i++) {
			drink[i] = Integer.parseInt(br.readLine());
		}

		long low = 0;
		long high = drink[n - 1];
		long mid = 0;
		while (low < high) {
			mid = (low + high) / 2;
			int canDrink = 0;
			for (int i = 0; i < drink.length; i++) {
				canDrink += drink[i] / mid;
			}
			if (canDrink < k)
				high = mid;
			else
				low = mid + 1;
		}
		System.out.println(high - 1);
		br.close();
	}

}
