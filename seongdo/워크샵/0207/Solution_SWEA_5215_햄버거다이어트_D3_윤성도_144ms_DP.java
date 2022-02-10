package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_SWEA_5215_햄버거다이어트_D3_윤성도_144ms_DP {
	static int N, L, dp[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int TC = 1; TC <= t; TC++) {
			bw.write("#" + TC + " ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			dp = new int[L+1];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				for(int cal = L; cal >= c; cal--) {
					if(dp[cal - c] + s > dp[cal]) dp[cal] = dp[cal - c] + s;
				}
			}
			bw.write(dp[L] + "\n");
		}
		bw.close();
	}
}
