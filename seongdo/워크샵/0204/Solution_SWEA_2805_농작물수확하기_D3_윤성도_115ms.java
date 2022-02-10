package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_2805_농작물수확하기_D3_윤성도_115ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int TC = 1; TC <= T; TC++) {
			sb.append("#").append(TC).append(" ");
			int N = Integer.parseInt(br.readLine());
			int M = N/2;
			int[][] farm = new int[N][N];
			int sum = 0;
			
			for(int i = 0; i < N; i++) {
				String tmp = br.readLine();
				for(int j = 0; j < N; j++) {
					farm[i][j] = tmp.charAt(j) - '0';
				}
			}
			
			// N X N 배열
			// M = N/2
			// 0	M 1 M
			// 1	M-1 3 M-1
			// ...
			// M-1	1 N-2 1
			// M	0 N 0
			// M+1	1 N-2 1
			// ...
			// N-1	M 1 M
			for(int i = 0; i < N; i++) {
				int O = (M - i) > 0 ? M - i : i - M;
				for(int j = O; j < N-O; j++) {
					sum += farm[i][j];
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}
}
