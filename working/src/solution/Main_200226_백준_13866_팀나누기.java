package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_200226_백준_13866_팀나누기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] levels = new int[4];
		for (int i = 0; i < levels.length; i++) {
			levels[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(levels);
		int team1 = levels[3] + levels[0];
		int team2 = levels[1] + levels[2];
		int gap = Math.abs(team1 - team2);
		System.out.println(gap);

		br.close();
	}

}
