package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_9095_123더하기_S3_윤성도 {
	static int[] dp = new int[11];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		dp[0] = 1; dp[1] = 1; dp[2] = 2;
		for(int i = 3; i < 11; ++i) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N]).append("\n");
		}
		System.out.print(sb.toString());
	}
}
