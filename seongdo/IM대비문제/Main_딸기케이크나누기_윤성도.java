package com.ssafy.IM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_딸기케이크나누기_윤성도 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for (int TC = 1; TC <= T; TC++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[][] map = new int[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++)
					map[i][j] = map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1] + Integer.parseInt(st.nextToken());
			}
			if (map[N][N] % 4 != 0) {
				sb.append("#").append(TC).append(" ").append(0).append("\n");
				continue;
			}
			int r = 0, c = 0;
			int half = map[N][N] / 2;
			for (int i = 1; i < N; i++)
				if (map[i][N] == half) {
					r = i;
					break;
				}
			for (int i = 1; i < N; i++)
				if (map[N][i] == half) {
					c = i;
					break;
				}
			sb.append("#").append(TC).append(" ").append(map[r][c] == half / 2 ? 1 : 0).append("\n");
		}
		System.out.print(sb.toString());
	}
}