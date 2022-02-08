package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_18111_마인크래프트_S2_윤성도_768ms{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int time = Integer.MAX_VALUE;
		int height = 0;
		int[][] map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int h = 256; h >= 0; h--) {
			int req = 0;
			int t = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					int tmp = h - map[i][j];
					req += tmp;
					t += (tmp < 0) ? -tmp * 2 : tmp;
				}
			}
			if(req <= B && t < time) {
				time = t;
				height = h;
			}
		}
		System.out.println(time + " " + height);
	}
}
