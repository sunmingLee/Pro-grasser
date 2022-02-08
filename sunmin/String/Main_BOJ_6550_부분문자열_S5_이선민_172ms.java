package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2개의 문자열 s와 t가 주어졌을 때 s가 t의 부분 문자열인지 판단하는 프로그램을 작성하라. 부분 문자열을 가지고 있는지 판단하는 방법은
 * t에서 몇 개의 문자를 제거하고 이를 순서를 바꾸지 않고 합쳤을 경우 s가 되는 경우를 이야기 한다.
 *
 */
public class Main_BOJ_6550_부분문자열_S5_이선민_172ms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		StringBuilder sb = new StringBuilder();

		// 읽어온 한 줄이 공백일때까지 (다음 테스트케이스가 없을때까지)
		while ((str = br.readLine()) != null && !str.isEmpty()) {

			st = new StringTokenizer(str, " ");
			char[] s = st.nextToken().toCharArray(); // 문자열 s
			char[] t = st.nextToken().toCharArray(); // 문자열 t
			int index = 0; // t와 비교할 s의 현재 문자 인덱스

			for (char c : t) {
				if (s[index] == c) {
					index++;
				}

				// s의 모든 문자를 다 찾았다면 for문 탈출
				if (index  == s.length) {
					sb.append("Yes").append("\n");
					break;
				}
			}

			if (index < s.length) {
				sb.append("No").append("\n");
			}

		} // end of while

		System.out.print(sb);
	} // end of main

} // end of class
