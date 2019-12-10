package boj.Sol1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_백준_16637_괄호추가하기_서울9반_신광식 {
	static int n;
	static long answer;
	static int[] a, v, d;
	static LinkedList<Long> oriDigit;
	static LinkedList<Character> oriOper;

	static long calc(long a, long b, char op) {
		long result = 0;
		switch (op) {
		case '+':
			result = a + b;
			break;
		case '*':
			result = a * b;
			break;
		case '-':
			result = a - b;
			break;
		case '/':
			result = a / b;
			break;
		default:
			break;
		}
		return result;
	}

	static void permComb(int start, int end, int cnt) {
		if (cnt == end) {
			LinkedList<Long> digit = new LinkedList<>(oriDigit);
			LinkedList<Character> oper = new LinkedList<>(oriOper);
			for (int i = 0; i < a.length; i++) {
				long x = digit.get(a[i] - i);
				long y = digit.get(a[i] + 1 - i);
				char op = oper.get(a[i] - i);
				long result = calc(x, y, op);
				digit.remove(a[i] - i);
				digit.remove(a[i] - i);
				digit.add(a[i] - i, result);
				oper.remove(a[i] - i);
			}
			int size = oper.size();
			for (int i = 0; i < size; i++) {
				long x = digit.get(0);
				long y = digit.get(1);
				char op = oper.get(0);
				long result = calc(x, y, op);
				digit.remove(0);
				digit.remove(0);
				oper.remove(0);
				digit.add(0, result);
			}
			answer = Math.max(answer, digit.get(0));
			return;
		}
		for (int i = start; i < d.length; i++) {
			if (i > 0 && v[i - 1] == 1)
				continue;
			if (v[i] == 0) {
				v[i] = 1;
				a[cnt] = d[i];
				permComb(i, end, cnt + 1);
				v[i] = 0;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		if (n == 1) {
			System.out.println(str);
		} else if (str.charAt(str.length() - 1) == '0' && str.charAt(str.length() - 2) == '*') {
			System.out.println(0);
		} else {
			oriDigit = new LinkedList<>();
			oriOper = new LinkedList<>();
			for (int i = 0; i < str.length(); i++) {
				if (i % 2 == 0 && Character.isDigit(str.charAt(i))) {
					oriDigit.add((long) (str.charAt(i) - '0'));
				} else if (i % 2 == 0 && !Character.isDigit(str.charAt(i))) {
					oriDigit.add((long) ((str.charAt(i + 1) - '0') * -1));
				} else
					oriOper.add(str.charAt(i));
			}
			d = new int[oriOper.size()];
			v = new int[oriOper.size()];
			for (int i = 0; i < d.length; i++) {
				d[i] = i;
			}
			answer = Long.MIN_VALUE;
			for (int i = 0; i < d.length; i++) {
				a = new int[i];
				permComb(0, i, 0);
			}
			System.out.println(answer);
		}
		br.close();
	}

}
