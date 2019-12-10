package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_백준_14395_4연산_서울9반_신광식 {
	static long n, target;
	static String answer;
	static TreeSet<Long> set;

	static class Pos {
		long val;
		String str;

		public Pos(long val, String str) {
			this.val = val;
			this.str = str;
		}
	}

	static Pos calc(long v, int d) {
		if (d == 0)
			return new Pos(v * v, "*");
		else if (d == 1)
			return new Pos(v + v, "+");
		else if (d == 2)
			return new Pos(v - v, "-");
		else
			return new Pos(v / v, "/");
	}

	static void bfs() {
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(new Pos(n, ""));
		set.add(n);
		while (!q.isEmpty()) {
			Pos curr = q.poll();
			if (curr.val == target) {
				answer = curr.str;
				return;
			}
			for (int d = 0; d < 4; d++) {
				Pos next = calc(curr.val, d);
				if (next.val < 1)
					continue;
				if (set.contains(next.val))
					continue;
				set.add(next.val);
				q.add(new Pos(next.val, curr.str + next.str));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		if (n == target)
			System.out.println("0");
		else {
			set = new TreeSet<>();
			answer = "-1";
			bfs();
			if (set.size() == 0)
				System.out.println(-1);
			else
				System.out.println(answer);
		}
		br.close();
	}

}
