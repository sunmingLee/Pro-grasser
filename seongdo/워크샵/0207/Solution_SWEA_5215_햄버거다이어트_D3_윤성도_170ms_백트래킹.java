package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_SWEA_5215_햄버거다이어트_D3_윤성도_170ms_백트래킹 {
	static int N, L, T[], K[], score;
	
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
			T = new int[N];
			K = new int[N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				T[i] = Integer.parseInt(st.nextToken());
				K[i] = Integer.parseInt(st.nextToken());
			}
			score = 0;
			hamberger(0, 0, 0);
			bw.write(score + "\n");
		}
		bw.close();
	}
	
	public static void hamberger(int index, int cur_score, int cur_cal) {
		if(cur_cal > L) return;
		else if(index == N) {
			if(cur_score > score) score = cur_score;
			return;
		}
		hamberger(index+1, cur_score + T[index], cur_cal + K[index]);
		hamberger(index+1, cur_score, cur_cal);
	}
}
