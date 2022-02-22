package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_2437_저울_G3_윤성도_80ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] w = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) w[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(w);
		int sum = 0;
		for(int i = 0; i < N; i++) {
			if(sum + 1 < w[i]) break;
			sum += w[i];
		}
		System.out.println(sum + 1);
	}
}
