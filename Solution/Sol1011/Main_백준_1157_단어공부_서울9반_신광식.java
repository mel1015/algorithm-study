package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_백준_1157_단어공부_서울9반_신광식 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		str = str.toUpperCase();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char a = str.charAt(i);
			if (!map.containsKey(a)) {
				map.put(a, 1);
			} else {
				int cnt = map.get(a);
				map.put(a, cnt + 1);
			}
		}
		List<Character> keySetList = new ArrayList<>(map.keySet());
		Collections.sort(keySetList, new Comparator<Character>() {
			@Override
			public int compare(Character o1, Character o2) {
				return map.get(o2).compareTo(map.get(o1));
			}
		});
		int max = map.get(keySetList.get(0));
		if (keySetList.size() > 1 && max == map.get(keySetList.get(1)))
			System.out.println("?");
		else
			System.out.println(keySetList.get(0));
		br.close();
	}

}
