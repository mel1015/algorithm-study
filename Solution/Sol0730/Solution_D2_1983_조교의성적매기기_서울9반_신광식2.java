package d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D2_1983_조교의성적매기기_서울9반_신광식2 {

	// 학생들의 성적을 저장할 Student 클래스, Student 객체끼리의 비교를 위해 Comparable을 implement
	public static class Student implements Comparable<Student> {
		// 중간, 기말, 과제, 번호, 성적
		int mid, finals, assign, index, score;

		public Student(int mid, int finals, int assign, int index) {
			this.mid = mid;
			this.finals = finals;
			this.assign = assign;
			this.index = index;
			this.score = mid * 35 + finals * 45 + assign * 20;
		}
		// Student 객체 끼리 비교할 함수
		// Student 객체를 매개변수로 받고, 현재 학생의 성적과 매개변수 학생의 성적을 비교
		@Override
		public int compareTo(Student o) {
			return score - o.score;
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1983.txt"));
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 성적 테이블
		String[] table = { "D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+" };
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// StringTokenizer 사용 => 줄을 읽어오고, 공백을 기준으로 나누어 토큰으로 저장
			// 입력 10 3 => 첫번째 토큰 10, 두번째 토큰 3
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(stk.nextToken());
			int k = Integer.parseInt(stk.nextToken());

			// 학생들의 성적을 저장할 Student 배열
			Student[] students = new Student[n];
			for (int i = 0; i < n; i++) {
				stk = new StringTokenizer(br.readLine());
				// 학생 객체 만들기
				students[i] = new Student(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()),
						Integer.parseInt(stk.nextToken()), i);
			}
			// Arrays.sort() => 위의 Student 클래스에서 오버라이딩한 비교함수로 정렬함
			Arrays.sort(students);
			for (int i = 0; i < n; i++) {
				if (students[i].index == k - 1) {
					// (n/10)명이 같은 성적을 받음
					System.out.println("#" + t + " " + table[i / (n / 10)]);
					break;
				}
			}
		}
	}

}
