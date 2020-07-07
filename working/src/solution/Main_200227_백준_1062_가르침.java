package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_200227_백준_1062_가르침 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		ArrayList<Character> toLearnChar = new ArrayList<>();

		int answer = 0;
		if (k < 5) {
			System.out.println(0);
		} else {
			for (int i = 0; i < n; i++) {
				String word = br.readLine();
				word = word.replaceAll("a|c|i|n|t", "");
				for (int j = 0; j < word.length(); j++) {
					char c = word.charAt(j);
					if (!toLearnChar.contains(c))
						toLearnChar.add(c);
				}
			}
		}
		System.out.println(answer);

		br.close();
	}

}
