package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_2001_파리퇴치_D2_윤성도_106ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int TC = 1; TC <= T; TC++) {
			sb.append("#").append(TC).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] fly = new int[N][N];
			int answer = 0;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					fly[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i <= N - M; i++) {
				for(int j = 0; j <= N - M; j++) {
					int tmp = 0;
					for(int i2 = i; i2 < i + M; i2++) {
						for(int j2 = j; j2 < j + M; j2++) {
							tmp += fly[i2][j2];
						}
					}
					if(tmp>answer) answer = tmp;
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}