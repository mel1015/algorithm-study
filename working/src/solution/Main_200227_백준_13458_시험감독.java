package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_200227_백준_13458_시험감독 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] rooms = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < rooms.length; i++) {
			rooms[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		long answer = 0;
		for (int i = 0; i < rooms.length; i++) {
			int people = rooms[i] - b;
			answer++;
			if (people <= 0) {
				continue;
			} else {
				int div = people / c;
				if (div * c >= people) {
					answer += div;
				} else {
					answer += div + 1;
				}
			}
		}
		System.out.println(answer);
		br.close();
	}

}
