package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_9465_스티커_S1_이선민_728ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine()); // 테스트케이스 개수
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int test_case = 0; test_case < TC; test_case++) {
			int n = Integer.parseInt(br.readLine()); // 열의 개수(1 ≤ n ≤ 100,000)
			int[][] stickers = new int[2][n + 1]; // dp와 위치 맞춰주기 위해
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= n; j++) {
					stickers[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] dp = new int[2][n + 1]; // 맨처음열 뒤의 열 값을 넣어줄때, 처음열과 비교할 대상이 필요하기 때문에 크기를 n+1로 설정
			dp[0][1] = stickers[0][1];
			dp[1][1] = stickers[1][1];
			for (int i = 2; i <= n; i++) {
				dp[0][i] = Math.max(dp[1][i - 2], dp[1][i - 1]) + stickers[0][i];
				dp[1][i] = Math.max(dp[0][i - 2], dp[0][i - 1]) + stickers[1][i];
			}
			sb.append(dp[0][n] > dp[1][n] ? dp[0][n] : dp[1][n]).append("\n");
		} // end of test_case
		System.out.print(sb.toString());
	} // end of main

} // end of class
