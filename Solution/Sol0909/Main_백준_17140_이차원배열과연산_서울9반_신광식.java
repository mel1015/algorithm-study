package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_백준_17140_이차원배열과연산_서울9반_신광식 {
	public static int r, c, k, rCnt, cCnt, answer;
	public static ArrayList<ArrayList<Integer>> map;

	public static int arrCalc() {
		int time = 0;
		while (time > 0) {
			time++;
			if (rCnt >= cCnt) {
				HashMap<Integer, Integer> hmap = new HashMap<>();
				for (int i = 0; i < map.size(); i++) {
					ArrayList<Integer> rowList = map.get(i);
					for (int j = 0; j < rowList.size(); j++) {
						int key = rowList.get(j);
						if (hmap.containsKey(key)) {
							int value = hmap.get(key);
							hmap.put(key, ++value);
						} else {
							hmap.put(key, 1);
						}
					}

				}
			}
		}
		return time;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			ArrayList<Integer> temp = new ArrayList<>();
			for (int j = 0; j < 3; j++) {
				temp.add(Integer.parseInt(st.nextToken()));
			}
			map.add(temp);
		}
		answer = 0;
		rCnt = 3;
		cCnt = 3;
		if (map.get(r - 1).get(c - 1) != k) {
			answer = arrCalc();
		}
		System.out.println(answer);
		br.close();
	}

}
