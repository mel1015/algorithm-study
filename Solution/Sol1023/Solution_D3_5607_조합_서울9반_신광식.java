package boj.Sol1023;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Fermat Little Theorem
// a^p=a(mod p)
// a^(p-1)=1
// a^(p-2)=1/a

// 5C2%7 -> 5!/(3!*2!)%7
// 		 -> 5!*6^5*2^5%7
//		 -> (5!%7)*(6^5%7)*(2^5%7)
//		 -> (5*4*3*2*1%7)*(6^5%7)*(2^5%7)
//		 -> (5*2*1%7)*(3*2)(6^5%7)*2(2^5%7)
//		 -> (10%7)*(6^6%7)*(2^5%7)
//		 -> 3%7*1%7*1%7
//		 -> 3%7
public class Solution_D3_5607_조합_서울9반_신광식 {
	static int n, r;
	static long[] fact, inv;

	static long modPower(long x, long y, long p) {
		long r = 1L;
		x = x % p;
		// ^7 7승이면 7번 곱해야하는데 연산 횟수 줄이는 방법
		// => 3^7 > 7 3 1 => 3^7=3^1*3^2*3^4
		while (y > 0) {
			if (y % 2 == 1)
				r = (r * x) % p;
			y = y >> 1;
			x = (x * x) % p;
		}
		return r;
	}

	static long modInverse(long a, long p) {
		return modPower(a, p - 2, p);
	}

	static long nCr(int n, int r, int p) {
		if (r == 0)
			return 1L;
		long[] fac = new long[n + 1];
		fac[0] = 1;
		for (int i = 1; i <= n; i++) {
			fac[i] = (fac[i - 1] * i) % p;
		}
		return (fac[n] * modInverse(fac[r], p) % p * modInverse(fac[n - r], p) % p) % p;
	}

	static long power(long a, long b) {
		long answer = 1;
		while (b > 0) {
			if (b % 2 == 1) {
				answer *= a;
				answer %= 1234567891;
			}
			a *= a;
			a %= 1234567891;
			b /= 2;
		}
		return answer;
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		fact = new long[1000001];
		inv = new long[1000001];

		fact[1] = 1;
		for (int i = 2; i <= 1000000; i++) {
			fact[i] = (fact[i - 1] * i) % 1234567891;
		}

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			long answer = 0;
			if (n == r || r == 0)
				answer = 1;
			else {
				inv[n] = power(fact[n], 1234567891 - 2);
				for (int i = n - 1; i > 0; i--) {
					inv[i] = (inv[i + 1] * (i + 1)) % 1234567891;
				}
				answer += fact[n];
				answer = (answer * inv[r]) % 1234567891;
				answer = (answer * inv[n - r]) % 1234567891;
			}
			System.out.println("#" + tc + " " + answer);
			System.out.println(nCr(n, r, 1234567891));
		}
		br.close();
	}

}
