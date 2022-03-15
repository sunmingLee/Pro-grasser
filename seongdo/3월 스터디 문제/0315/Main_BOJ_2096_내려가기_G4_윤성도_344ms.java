package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2096_내려가기_G4_윤성도_344ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] max = new int[3];
		int[] min = new int[3];
		int[] input = new int[3];
		int[] cur;
		while(N-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 3; i++) input[i] = Integer.parseInt(st.nextToken());
			cur = new int[3];
			cur[0] = Integer.max(max[0], max[1]) + input[0];
			cur[1] = Integer.max(max[0], Integer.max(max[1], max[2])) + input[1];
			cur[2] = Integer.max(max[1], max[2]) + input[2];
			max = cur;
			cur = new int[3];
			cur[0] = Integer.min(min[0], min[1]) + input[0];
			cur[1] = Integer.min(min[0], Integer.min(min[1], min[2])) + input[1];
			cur[2] = Integer.min(min[1], min[2]) + input[2];
			min = cur;
		}
		System.out.print(Integer.max(max[0], Integer.max(max[1], max[2])) + " " + Integer.min(min[0], Integer.min(min[1], min[2])));
	}
}
