package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구간합을 바로바로 구하면, 최악의 경우 N^2*M ~= 10^11 -> 시간초과
 * 
 * --> DP로 해당 칸까지의 누적합을 구해둔 뒤, 원하는 구간합을 이를 이용해 출력한다.
 */
public class Main_BOJ_11660_구간합구하기5_S1_이선민_728ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 배열의 한변 길이(1 ≤ N ≤ 1024)
		int M = Integer.parseInt(st.nextToken()); // 합을 구해야하는 횟수(1 ≤ M ≤ 100,000)
		int[][] dp = new int[N + 1][N + 1]; // 0행, 0열의 계산을 위해 그 바깥쪽에 한겹씩 둘러줌
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + Integer.parseInt(st.nextToken());
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 원하는 구간합을 구하기 위해 주어진 x1, y1 좌표보다 1씩 작은값이 필요하기 때문에 후의 연산을 줄이기 위해 받아올때 미리 -1을 해줌
			int x1 = Integer.parseInt(st.nextToken()) - 1;
			int y1 = Integer.parseInt(st.nextToken()) - 1;
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			sb.append(dp[x2][y2] - dp[x1][y2] - dp[x2][y1] + dp[x1][y1]).append("\n");
		}
		System.out.print(sb.toString());
	} // end of main

} // end of class
