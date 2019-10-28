package d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_D3_1230_암호문3_서울9반_신광식 {
	public static ArrayList<String> arr;
	public static String[] cmd;

	public static void process() {
		// 명령어 개수만큼 실행
		for (int i = 0; i < cmd.length; i++) {
			// 앞에서부터 x의 위치 바로 다음, y개의 숫자, s는 덧붙일 숫자들
			int x = 0, y = 0;
			if (cmd[i].equals("I")) {
				// ++i => 선증감연산자를 사용하여 명령어 I 다음의 x, y
				x = Integer.parseInt(cmd[++i]);
				y = Integer.parseInt(cmd[++i]);
				for (int j = 0; j < y; j++) {
					arr.add(x++, cmd[++i]);
				}
			} else if (cmd[i].equals("D")) {
				x = Integer.parseInt(cmd[++i]);
				y = Integer.parseInt(cmd[++i]);
				for (int j = 0; j < y; j++) {
					arr.remove(x++);
				}
			} else if (cmd[i].equals("A")) {
				y = Integer.parseInt(cmd[++i]);
				for (int j = 0; j < y; j++) {
					arr.add(arr.size(), cmd[++i]);
				}
			}
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1230.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			// 숫자 개수 N
			br.readLine();

			// ArrayList에 입력
			String[] temp = br.readLine().split(" ");
			arr = new ArrayList<>(Arrays.asList(temp));

			// 명령어 개수, 명령어 배열 cmd
			br.readLine();
			cmd = br.readLine().split(" ");

			// 명령 실행
			process();

			// 정답 출력
			System.out.print("#" + tc + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(arr.get(i) + " ");
			}
			System.out.println();
		}
	}

}
