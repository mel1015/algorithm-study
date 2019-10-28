package boj.Sol1023;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
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
public class Solution_D3_5607_조합_서울9반_신광식_BigInt {
	static int p = 1234567891;

	static BigInteger nCr(int n, int r, int p) {
		long[] fac = new long[n + 1];
		fac[0] = 1;
		for (int i = 1; i <= n; i++) {
			fac[i] = (fac[i - 1] * i) % p;
		}
		BigInteger P = BigInteger.valueOf(p);
		BigInteger A = BigInteger.valueOf(fac[n]);
		BigInteger B = BigInteger.valueOf(fac[r]).modInverse(P).remainder(P);
		BigInteger C = BigInteger.valueOf(fac[n - r]).modInverse(P).remainder(P);
		return A.multiply(B).multiply(C).remainder(P);
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			System.out.println("#" + tc + " " + nCr(n, r, p));
		}
		br.close();
	}

}
