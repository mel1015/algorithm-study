package d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D2_1940_가랏RC카_서울9반_신광식 {

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d2_1940.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] cmd = new int[n][2];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				cmd[i][0] = Integer.parseInt(st.nextToken());
				if (cmd[i][0] != 0)
					cmd[i][1] = Integer.parseInt(st.nextToken());
			}
			int answer = 0, speed = 0;
			for (int i = 0; i < n; i++) {
				if (cmd[i][0] == 1) {
					speed += cmd[i][1];
					answer += speed;
				} else if (cmd[i][0] == 2) {
					if (cmd[i][1] > speed)
						speed = 0;
					else
						speed -= cmd[i][1];
					answer += speed;
				} else {
					answer += speed;
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
