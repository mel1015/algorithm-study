package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_200225_백준_1759_암호만들기 {
	static int l, c, maxVowel, maxConsonant;
	static ArrayList<Character> vowels, consonants;
	static ArrayList<String> answers;
	static boolean[] visitV, visitC;

	static void combConsonat(int start, int count, String vowelStr) {
		if (count == maxConsonant) {
			String consonantStr = "";
			for (int i = 0; i < visitC.length; i++) {
				if (visitC[i]) {
					consonantStr += consonants.get(i);
				}
			}
			vowelStr += consonantStr;
			char[] arr = vowelStr.toCharArray();
			Arrays.sort(arr);
			answers.add(new String(arr));
			return;
		}
		for (int i = start; i < consonants.size(); i++) {
			if (!visitC[i]) {
				visitC[i] = true;
				combConsonat(i, count + 1, vowelStr);
				visitC[i] = false;
			}
		}
	}

	static void combVowel(int start, int count, int limit) {
		if (count == limit) {
			String vowelStr = "";
			for (int i = 0; i < visitV.length; i++) {
				if (visitV[i]) {
					vowelStr += vowels.get(i);
				}
			}
			combConsonat(0, 0, vowelStr);
			return;
		}
		for (int i = start; i < vowels.size(); i++) {
			if (!visitV[i]) {
				visitV[i] = true;
				combVowel(i, count + 1, limit);
				visitV[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		vowels = new ArrayList<>();
		consonants = new ArrayList<>();
		answers = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			char c = st.nextToken().charAt(0);
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
				vowels.add(c);
			else
				consonants.add(c);
		}

		if (vowels.size() >= 1 && consonants.size() >= 2) {
			visitV = new boolean[vowels.size()];
			visitC = new boolean[consonants.size()];
			maxVowel = l - 2;
			for (int i = 1; i <= maxVowel; i++) {
				maxConsonant = l - i;
				if (maxConsonant < 2)
					break;
				combVowel(0, 0, i);
				Arrays.fill(visitV, false);
				Arrays.fill(visitC, false);
			}
			Collections.sort(answers);
			for (int i = 0; i < answers.size(); i++) {
				System.out.println(answers.get(i));
			}
		}
		br.close();
	}

}
