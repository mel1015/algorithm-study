package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_16916_부분문자열_200224 {

	static int hashing(String s) {
		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			ans = (ans * 256 + s.charAt(i)) % 127;
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String p = br.readLine();
		int n = s.length();
		int m = p.length();

		if (n < m) {
			System.out.println(0);
			System.exit(0);
		}

		int hashP = hashing(p);
		int hashS = hashing(s.substring(0, m));
		int first = 1;
		for (int i = 0; i < m - 1; i++) {
			first = (first * 256) % 127;
		}

		for (int i = 0; i <= n - m; i++) {
			if (hashP == hashS) {
				if (s.substring(i, i + m).equals(p)) {
					System.out.println(1);
					System.exit(0);
				}
			}
			if ((i + m) < n) {
				hashS = hashS - (s.charAt(i) * first) % 127;
				hashS = (hashS + 127) % 127;
				hashS = ((hashS * 256) % 127 + s.charAt(i + m)) % 127;
			}
		}
		System.out.println(0);
		br.close();
	}
}
