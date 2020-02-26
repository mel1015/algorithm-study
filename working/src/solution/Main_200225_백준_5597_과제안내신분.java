package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_200225_백준_5597_과제안내신분 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean[] submit = new boolean[31];
		for (int i = 1; i <= 28; i++) {
			int num = Integer.parseInt(br.readLine());
			submit[num] = true;
		}
		for (int i = 1; i < submit.length; i++) {
			if (!submit[i])
				System.out.println(i);
		}
		br.close();
	}

}
