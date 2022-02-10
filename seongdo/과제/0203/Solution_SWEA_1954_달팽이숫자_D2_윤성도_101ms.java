package com.ssafy.SWEA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_1954_달팽이숫자_D2_윤성도_101ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int TC = 1; TC <= T; TC++) {
			int N = Integer.parseInt(br.readLine());
			int[][] answer = new int[N][N];
			int dir = 0;
			int x = 0;
			int y = 0;
			int[] dx = {1, 0, -1, 0};
			int[] dy = {0, 1, 0, -1};
			
			for(int i = 1; i <= N*N; i++) {
				answer[y][x] = i;
				x += dx[dir];
				y += dy[dir];
				if(x<0 || N<=x || y<0 || N<=y || answer[y][x]!=0) {
					x -= dx[dir];
					y -= dy[dir];
					if(++dir == 4) dir = 0;
					x += dx[dir];
					y += dy[dir];
				}
			}
			
			sb.append("#").append(TC).append("\n");
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					sb.append(answer[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}