package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main_200227_백준_1316_그룹단어체커 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		loop: for (int i = 0; i < n; i++) {
			HashSet<Character> hs = new HashSet<>();
			String word = br.readLine();

			char firstC = word.charAt(0);
			hs.add(firstC);

			int beginIndex = 1;
			int endIndex = word.length();

			while (beginIndex < endIndex) {
				if (firstC == word.charAt(beginIndex)) {
					beginIndex++;
				} else {
					if (hs.contains(word.charAt(beginIndex))) {
						continue loop;
					}
					firstC = word.charAt(beginIndex);
					hs.add(firstC);
					word = word.substring(beginIndex, word.length());
					beginIndex = 1;
					endIndex = word.length();
				}
			}
			answer++;
		}
		System.out.println(answer);
		br.close();
	}

}
