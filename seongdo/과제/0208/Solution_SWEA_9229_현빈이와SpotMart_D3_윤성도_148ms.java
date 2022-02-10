package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_SWEA_9229_현빈이와SpotMart_D3_윤성도_148ms {
	private static int N, M, wt[], answer;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int TC = 1; TC <= T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			answer = -1;
			wt = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) wt[i] = Integer.parseInt(st.nextToken());
			take(0, 0, 0);
			bw.write("#" + TC + " " + answer + "\n");
		}
		bw.close();
	}
	
	public static void take(int index, int num, int weight) {
		if(weight>M) return;
		if(num==2) {
			if(answer < weight) answer = weight;
			return;
		}
		if(index==N) return;
		take(index+1, num+1, weight+wt[index]);
		take(index+1, num, weight);
	}
}
