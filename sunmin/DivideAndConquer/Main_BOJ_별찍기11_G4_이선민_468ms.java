package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_별찍기11_G4_이선민_468ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N은 항상 3×2^k 수이다. (3, 6, 12, 24, 48, ...) (0 ≤ k ≤ 10, k는 정수)
		int N = Integer.parseInt(br.readLine());
		// 제일 기본 모양(공백포함 5x5 크기, k=0인 모양 / 위에서부터 별 1, 2, 5개)
		String[] star = new String[N];
		star[0] = "  *  ";
		star[1] = " * * ";
		star[2] = "*****";

		for (int k = 1; 3 * (1 << k) <= N; k++) {
			makeStar(k, star);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(star[i]).append("\n");
		}
		System.out.print(sb);
	} // end of main

	private static void makeStar(int k, String[] star) {
		int bottom = 3 * (1 << k); // k번째 모양의 가장 아래줄
		int middle = bottom / 2; // k-1번째의 모양을 그대로 따라하기 시작할 줄

		for (int i = middle; i < bottom; i++) {
			star[i] = star[i - middle] + " " + star[i - middle]; // 가운데 공백을 두고 k-1번의 모양을 그대로 그림
		}

		// k-1번 모양의 앞,뒤 공백 조정해주기
		String space = "";
		while (space.length() < middle) {
			space += " ";
		}
		for (int i = 0; i < middle; i++) {
			star[i] = space + star[i] + space;
		}
	} // end of makeStar

} // end of class
