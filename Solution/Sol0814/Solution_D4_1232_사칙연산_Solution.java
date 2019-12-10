package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1232_사칙연산_Solution {
	static class Node {
		boolean isNum;
		double num;
		char op;
		int lidx;
		int ridx;
	}

	public static Node[] nodes;

	public static double getNum(int idx) {
		if (nodes[idx].isNum)
			return nodes[idx].num;

		double num = -1.0;
		switch (nodes[idx].op) {
		case '+':
			num = getNum(nodes[idx].lidx) + getNum(nodes[idx].ridx);
			break;
		case '-':
			num = getNum(nodes[idx].lidx) - getNum(nodes[idx].ridx);
			break;
		case '*':
			num = getNum(nodes[idx].lidx) * getNum(nodes[idx].ridx);
			break;
		case '/':
			num = getNum(nodes[idx].lidx) / getNum(nodes[idx].ridx);
			break;

		default:
			break;
		}
		return num;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1232.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			nodes = new Node[n + 1];

			for (int i = 1; i <= n; i++) {
				Node node = new Node();
				nodes[i] = node;

				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String s = st.nextToken();
				char c = s.charAt(0);
				if ('0' <= c && c <= '9') {
					node.isNum = true;
					node.num = Integer.parseInt(s);
				} else {
					node.isNum = false;
					node.op = c;
					node.lidx = Integer.parseInt(st.nextToken());
					node.ridx = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#" + tc + " " + (int) getNum(1));
		}
		br.close();
	}

}