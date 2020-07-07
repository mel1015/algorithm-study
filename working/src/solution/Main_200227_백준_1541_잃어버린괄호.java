package solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_200227_백준_1541_잃어버린괄호 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String calc = br.readLine();

		StringTokenizer st = new StringTokenizer(calc, "+-");
		Queue<Integer> numberQ = new LinkedList<>();
		while (st.hasMoreTokens()) {
			numberQ.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(calc, "0123456789");
		Queue<Character> operationQ = new LinkedList<>();
		while (st.hasMoreTokens()) {
			operationQ.add(st.nextToken().charAt(0));
		}

		int answer = numberQ.poll();
		int sub = 0;
		while (!operationQ.isEmpty()) {
			char op = operationQ.peek();
			if (op == '+') {
				operationQ.poll();
				answer += numberQ.poll();
			} else {
				break;
			}
		}

		while (!operationQ.isEmpty()) {
			operationQ.poll();
			sub += numberQ.poll();
		}
		System.out.println(answer - sub);
		br.close();
	}

}
