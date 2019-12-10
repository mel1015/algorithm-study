package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_D4_1222_계산기1_서울9반_신광식 {
	public static Stack<Character> st = new Stack<Character>();

	// In coming priority
	public static int getIcp(char c) {
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '(':
			return 3;
		default:
			return 0;
		}
	}

	// In stack priority
	public static int getIsp() {
		char c = st.empty() ? ' ' : st.peek();
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '(':
			return 0;
		default:
			return 0;
		}
	}

	public static String toPostfix(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (Character.isDigit(c)) {
				// 토큰이 피연산자이면 토큰을 출력
				sb.append(c);
			} else if (c == ')') {
				// 토큰이 ')' 이면 '('를 만날 때까지 pop
				// pop한 연산자들을 출력
				char s;
				while ((s = st.pop()) != '(') {
					sb.append(s);
				}
			} else if (c == ' ') {
				continue;
			} else { // +, -, *, /
				// 토큰이 연산자이면, 스택의 top에 저장되어 있는 연산자 보다
				// 우선순위가 높으면 스텍에 push, 아니면 top의 우선순위가
				// 토큰보다 작을 때까지 스택에서 pop하여 출력 후에 현재 연산자 push
				while (getIcp(c) <= getIsp()) {
					sb.append(st.pop());
				}
				st.push(c);
			}
		}
		// 스택에 남아 있는 모든 연산자를 pop하여 출력
		while (!st.empty()) {
			sb.append(st.pop());
		}
		return sb.toString();
	}

	public static int postfixToCalc(String str) {
		Stack<Integer> st2 = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (Character.isDigit(c)) {
				// 피연산자  push
				st2.push(c - '0');
			} else {
				// 연산자를 만나면 pop하여 계산 후 결과 push
				int n2 = st2.pop();
				int n1 = st2.pop();
				int nn = 0;
				switch (c) {
				case '+':
					nn = n1 + n2;
					break;
				case '-':
					nn = n1 - n2;
					break;
				case '*':
					nn = n1 * n2;
					break;
				case '/':
					nn = n1 / n2;
					break;
				}
				st2.push(nn);
			}
		}
		return st2.pop();
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1222.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();

			int answer = postfixToCalc(toPostfix(str));

			System.out.println("#" + tc + " " + answer);
		}
	}

}
