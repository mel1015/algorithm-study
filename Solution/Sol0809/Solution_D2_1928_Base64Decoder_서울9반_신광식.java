package d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D2_1928_Base64Decoder_서울9반_신광식 {
	static int[] encodeMap = new int[128];

	static void makeMap() {
		for (int i = 0; i < 26; i++)
			encodeMap['A' + i] = i;
		for (int i = 0; i < 26; i++)
			encodeMap['a' + i] = 26 + i;
		for (int i = 0; i < 11; i++)
			encodeMap['0' + i] = 52 + i;
		encodeMap['+'] = 62;
		encodeMap['/'] = 63;
	}

	static void decode(char[] src, char[] dst) {
		int bits, pos = 0, pos2 = 0;
		while (src[pos] > 0) {
			bits = encodeMap[src[pos++]] << 18;
			bits += encodeMap[src[pos++]] << 12;
			bits += encodeMap[src[pos++]] << 6;
			bits += encodeMap[src[pos++]];
			dst[pos2++] = (char) (bits >> 16 & 0xFF);
			dst[pos2++] = (char) (bits >> 8 & 0xFF);
			dst[pos2++] = (char) (bits & 0xFF);
		}
		dst[pos2] = 0;
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d2_1928.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		makeMap();
		for (int tc = 1; tc <= T; tc++) {
			char[] encodeArr = new char[100000];
			String str = br.readLine();
			for (int i = 0; i < str.length(); i++) {
				encodeArr[i] = str.charAt(i);
			}
			char[] decodeArr = new char[100000];
			decode(encodeArr, decodeArr);
			System.out.print("#" + tc + " ");
			for (int i = 0; i < decodeArr.length; i++) {
				System.out.print(decodeArr[i]);
				if (decodeArr[i] == '.')
					break;
			}
			System.out.println();
		}
		br.close();
	}

}
