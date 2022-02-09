package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_SWEA_1210_Ladder1_D4_윤성도 {
	static int goal, N = 100, cur_load, i, j;
	static int[][] ladder = new int[N][N+2];
	static int[] load = new int[N/2+1];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input;
		StringTokenizer st;
		
		while((input = br.readLine())!=null) {
			bw.write("#" + input + " ");
			for(i=0; i<N-1; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(j=1; j<=N; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(br.readLine(), " ");
			for(j=1, cur_load=0; j<=N; j++) {
				switch(ladder[N-1][j] = Integer.parseInt(st.nextToken())) {
				case 2: goal = cur_load;
				case 1: load[cur_load++]=j;
				}
			}
			cur_load = goal;
			for(i=N-1; i>=0; i--) {
				if(ladder[i][load[cur_load]-1]==1) cur_load--;
				else if(ladder[i][load[cur_load]+1]==1) cur_load++;
			}
			bw.write(load[cur_load]-1 + "\n");
		}
		bw.close();
	}
}
