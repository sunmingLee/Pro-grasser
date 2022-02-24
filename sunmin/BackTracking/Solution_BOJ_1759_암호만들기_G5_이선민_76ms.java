package BackTracking;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_BOJ_1759_암호만들기_G5_이선민_76ms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// (3 ≤ L ≤ C ≤ 15)
		int L = Integer.parseInt(st.nextToken()); // 암호를 이루는 소문자의 개수
		int C = Integer.parseInt(st.nextToken()); // 암호로 사용했을 법한 문자의 종류
		st = new StringTokenizer(br.readLine(), " ");
		char[] alpha = new char[C]; // 암호로 사용했을 법한 문자들
		for (int i = 0; i < C; i++) {
			alpha[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(alpha); // 사전식으로 정렬

		StringBuilder sb = new StringBuilder();
		char[] pw = new char[L]; // 만든 암호문을 담을 배열
		makepw(0, 0, 0, pw, alpha, L, sb);
		System.out.print(sb);
	} // end of main

	private static void makepw(int vowel, int consonant, int start, char[] pw, char[] alpha, int L, StringBuilder sb) {
		int cnt = vowel + consonant;
		if (cnt == L && vowel >= 1 && consonant >= 2) { // 조건 모두 만족할 경우
			for (char c : pw) {
				sb.append(c);
			}
			sb.append("\n");	
			return;
		} else if (cnt == L) { // 조건을 만족하지 못하는 암호문이 만들어졌을 경우
			return;
		}

		for (int i = start; i < alpha.length; i++) {
			pw[cnt] = alpha[i];
			// 만약 현재 문자가 모음이라면
			if (alpha[i] == 'a' || alpha[i] == 'e' || alpha[i] == 'i' || alpha[i] == 'o' || alpha[i] == 'u') {
				makepw(vowel + 1, consonant, i + 1, pw, alpha, L, sb);
			} else { // 만약 현재 문자가 자음이라면
				makepw(vowel, consonant + 1, i + 1, pw, alpha, L, sb);
			}
		}

	} // end of makepw

} // end of class
