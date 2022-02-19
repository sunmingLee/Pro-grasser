package com.ssafy.IM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_11339_ATM_S3_윤성도 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] P = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) P[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(P);
		int ans = 0;
		for(int i = 0; i < N; i++) ans += P[i]*(N-i);
		System.out.println(ans);
	}
}