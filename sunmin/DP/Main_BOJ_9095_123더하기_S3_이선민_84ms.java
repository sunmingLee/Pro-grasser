package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_9095_123더하기_S3_이선민_84ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
//		int[] dp = new int[11];
		int[] dp = {1,2,4,7,13,24,44,81,149,274};
//		dp[1] = 1;
//		dp[2] = 2;
//		dp[3] = 4;
//		for (int i = 4; i < 11; i++) {
//			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
//		}
//		for (int i = 1; i < dp.length; i++) {
//			System.out.println(dp[i]);
//		}
		
		for (int test_case = 0; test_case < TC; test_case++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append("\n");
		} // end of test_case
		System.out.println(sb.toString());
	}

}
