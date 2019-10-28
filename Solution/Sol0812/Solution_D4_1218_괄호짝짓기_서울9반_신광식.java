package d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_D4_1218_괄호짝짓기_서울9반_신광식 {
	public static Stack<Character> st;

	public static int solution(String data) {
		st = new Stack<>();
		for (int i = 0; i < data.length(); i++) {
			char c = data.charAt(i);
			if (c == '(' || c == '{' || c == '[' || c == '<') {
				st.push(c);
			} else {
				char ch = st.pop();
				if ((c == ')' && ch != '(') || 
					(c == ']' && ch != '[') || 
					(c == '}' && ch != '{') ||
					(c == '>' && ch != '<')) {
					return 0;
				}
			}
		}
		return 1;
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1218.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			String data = br.readLine();
			int answer = solution(data);
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}

}
