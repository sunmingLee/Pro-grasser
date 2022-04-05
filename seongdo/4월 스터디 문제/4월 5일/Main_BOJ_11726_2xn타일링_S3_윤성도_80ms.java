package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_11726_2xn타일링_S3_윤성도_80ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];
		dp[0] = 1; dp[1] = 1;
		for (int i = 2; i <= n; i++) dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		System.out.print(dp[n]);
	}
}
