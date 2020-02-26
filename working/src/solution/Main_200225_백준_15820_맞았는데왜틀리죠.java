package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_200225_백준_15820_맞았는데왜틀리죠 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int s1 = Integer.parseInt(st.nextToken());
		int s2 = Integer.parseInt(st.nextToken());

		int flag = 0;
		for (int i = 0; i < s1; i++) {
			st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			if (x != y) {
				flag = 1;
			}
		}
		if (flag == 0) {
			for (int i = 0; i < s2; i++) {
				st = new StringTokenizer(br.readLine());
				long x = Long.parseLong(st.nextToken());
				long y = Long.parseLong(st.nextToken());
				if (x != y) {
					flag = 2;
				}
			}
		}

		if (flag == 1) {
			System.out.println("Wrong Answer");
		} else if (flag == 2) {
			System.out.println("Why Wrong!!!");
		} else {
			System.out.println("Accepted");
		}
		br.close();
	}

}
