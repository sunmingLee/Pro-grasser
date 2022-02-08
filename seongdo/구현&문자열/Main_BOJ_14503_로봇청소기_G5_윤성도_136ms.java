package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14503_로봇청소기_G5_윤성도_136ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		int[][] map = new int[N][M];
		int ans = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			if(map[r][c] == 0) {
				ans++;
				map[r][c] = 2;
			}
			while(true) {
				if(map[r-1][c]!=0&&map[r+1][c]!=0&&map[r][c-1]!=0&&map[r][c+1]!=0) {
					r=r-dr[d];
					c=c-dc[d];
					if(map[r][c]==1) {
						System.out.println(ans);
						return;
					}
				}else {
					d = d==0 ? 3 : d-1;
					if(map[r+dr[d]][c+dc[d]]==0) {
						r+=dr[d];
						c+=dc[d];
						break;
					}
				}
			}
		}
	}
}
