package boj.Sol1023;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1658_최대공약수와최소공배수_서울9반_신광식 {
	static int a, b;

	static int gcd(int a, int b) {
		int temp = 0;
		while (b != 0) {
			temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		int gcdVal = gcd(a, b);
		System.out.println(gcdVal);
		System.out.println((a * b) / gcdVal);
		br.close();
	}

}
