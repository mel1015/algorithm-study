package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_200723_백준_6588_골드바흐의추측 {
	static boolean[] notPrime;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		notPrime = new boolean[1000001];

		notPrime[0] = true;
		notPrime[1] = true;
		for (int i = 2; i <= Math.sqrt(1000000); i++) {
			if (notPrime[i])
				continue;
			for (int j = i + i; j <= 1000000; j += i) {
				notPrime[j] = true;
			}
		}

		while (true) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0)
				break;

			boolean find = false;
			for (int i = num - 1; i >= 3; i--) {
				if (!notPrime[i]) {
					int a = i;
					int sub = num - a;
					if (!notPrime[sub]) {
						find = true;
						System.out.println(num + " = " + sub + " + " + a);
						break;
					}
				}
			}
			if (!find)
				System.out.println("Goldbach's conjecture is wrong.");
		}

		br.close();
	}
}