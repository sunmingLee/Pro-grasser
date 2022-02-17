package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_SWEA_4012_요리사_윤성도_150ms {
	private static int N, halfN, ing[], syn[][];
	private static ArrayList<Integer> taste;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int TC = 1; TC <= T; TC++) {
			sb.append("#").append(TC).append(" ");
			N = Integer.parseInt(br.readLine());
			halfN= N/2;
			syn = new int[N][N];
			StringTokenizer st;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) syn[i][j] = Integer.parseInt(st.nextToken());
			}
			taste = new ArrayList<Integer>();
			ing = new int[halfN];
			comb(0, 0);
			int answer = Integer.MAX_VALUE, i = 0, j = taste.size()-1;
			while(i<j) answer = Math.min(answer, Math.abs(taste.get(i++) - taste.get(j--)));
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static void comb(int index, int r) {
		if(N-index < halfN - r) return;
		if(r == halfN) {
			int sum = 0;
			for(int i = 0; i < r; i++) {
				for(int j = i+1; j < r; j++) {
					sum += syn[ing[i]][ing[j]];
					sum += syn[ing[j]][ing[i]];
				}
			}
			taste.add(sum);
			return;
		}
		for(int i = index; i < N; i++) {
			ing[r] = i;
			comb(i+1, r+1);
		}
	}
}