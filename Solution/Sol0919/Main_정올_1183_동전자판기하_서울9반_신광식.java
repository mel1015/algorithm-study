package jo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1183_동전자판기하_서울9반_신광식 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int w = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] coin = new int[6];
		int[] value = { 500, 100, 50, 10, 5, 1 };
		int maxMoney = 0;
		for (int i = 0; i < coin.length; i++) {
			coin[i] = Integer.parseInt(st.nextToken());
			maxMoney += coin[i] * value[i];
		}

		maxMoney -= w;
		int idx = 0;
		while (true) {
			if (maxMoney == 0 || idx >= 6)
				break;
			if (coin[idx] == 0 || maxMoney < value[idx]) {
				idx++;
				continue;
			}
			maxMoney -= value[idx];
			coin[idx]--;
		}

		int sum = 0;
		for (int i = 0; i < coin.length; i++) {
			sum += coin[i];
		}
		System.out.println(sum);
		for (int i = 0; i < coin.length; i++) {
			System.out.print(coin[i] + " ");
		}

		br.close();
	}

}
