package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_16198_에너지모으기_서울9반_신광식 {
	static int n, answer;
	static ArrayList<Integer> list;

	static void dfs(int start, int cnt, int sum, ArrayList<Integer> pList) {
		if (cnt == n - 2) {
			answer = Math.max(answer, sum);
			return;
		}
		ArrayList<Integer> temp = new ArrayList<>(pList);
		for (int i = 1; i < temp.size() - 1; i++) {
			int energy = temp.get(i - 1) * temp.get(i + 1);
			int num = temp.get(i);
			temp.remove(i);
			dfs(i, cnt + 1, sum + energy, temp);
			temp.add(i, num);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		answer = 0;
		dfs(0, 0, 0, list);
		System.out.println(answer);
		br.close();
	}

}
