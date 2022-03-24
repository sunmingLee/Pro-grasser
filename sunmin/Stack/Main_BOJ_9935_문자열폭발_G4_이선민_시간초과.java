package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_9935_문자열폭발_G4_이선민_시간초과 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sb.append(br.readLine());
		String bomb = br.readLine(); // 폭발 문자열
		int bombLength = bomb.length() - 1;
		while (true) {
			boolean flag = false;
			for (int i = sb.length() - 1, start = i - bombLength; start >= 0; i--, start--) {
				if (i >= sb.length()) {
					continue;
				}
//				System.out.println(sb.substring(start, i + 1));
				if (sb.substring(start, i + 1).equals(bomb)) {
					sb.delete(start, i + 1);
					flag = true;
				}
			}
//			System.out.println(sb.toString());
			if (!flag) {
				break;
			}
		}

		if (sb.length() == 0) {
			System.out.println("FRULA");
		} else {
			System.out.println(sb.toString());
		}
	} // end of main

} // end of class
