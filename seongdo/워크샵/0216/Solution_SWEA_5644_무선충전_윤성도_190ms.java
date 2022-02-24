package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_5644_무선충전_윤성도_190ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int TC = 1; TC <= T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			String inputA = br.readLine();
			String inputB = br.readLine();
			int[] moveA = new int[M];
			int[] moveB = new int[M];
			for (int i = 0; i < M; i++) {
				moveA[i] = inputA.charAt(i << 1) - '0';
				moveB[i] = inputB.charAt(i << 1) - '0';
			}
			int[][] BC = new int[A][4];
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 4; j++)
					BC[i][j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(BC, (a, b) -> b[3] - a[3]);
			ArrayList<Integer>[][] map = new ArrayList[11][11];
			for (int i = 1; i <= 10; i++)
				for (int j = 1; j <= 10; j++)
					map[i][j] = new ArrayList<Integer>();
			int[][][] d = new int[5][][];
			d[0] = new int[][] { { 0, 0 } };
			d[1] = new int[][] { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
			d[2] = new int[][] { { -2, 0 }, { -1, 1 }, { 0, 2 }, { 1, 1 }, { 2, 0 }, { 1, -1 }, { 0, -2 }, { -1, -1 } };
			d[3] = new int[][] { { -3, 0 }, { -2, 1 }, { -1, 2 }, { 0, 3 }, { 1, 2 }, { 2, 1 }, { 3, 0 }, { 2, -1 },
					{ 1, -2 }, { 0, -3 }, { -1, -2 }, { -2, -1 } };
			d[4] = new int[][] { { -4, 0 }, { -3, 1 }, { -2, 2 }, { -1, 3 }, { 0, 4 }, { 1, 3 }, { 2, 2 }, { 3, 1 },
					{ 4, 0 }, { 3, -1 }, { 2, -2 }, { 1, -3 }, { 0, -4 }, { -1, -3 }, { -2, -2 }, { -3, -1 } };
			for (int i = 0; i < A; i++) {
				int r = BC[i][0], c = BC[i][1];
				for (int j = 0, size = BC[i][2]; j <= size; j++) {
					for (int k = 0, len = d[j].length; k < len; k++) {
						int curR = r + d[j][k][0], curC = c + d[j][k][1];
						if (curR <= 0 || curR > 10 || curC <= 0 || curC > 10)
							continue;
						map[curC][curR].add(i);
					}
				}
			}
			int rA = 1, cA = 1, rB = 10, cB = 10, ans = 0;
			if (!map[cA][rA].isEmpty())
				ans += BC[map[cA][rA].get(0)][3];
			if (!map[cB][rB].isEmpty())
				ans += BC[map[cB][rB].get(0)][3];
			for (int i = 0; i < M; i++) {
				if (moveA[i] != 0) {
					rA += d[1][moveA[i] - 1][0];
					cA += d[1][moveA[i] - 1][1];
				}
				if (moveB[i] != 0) {
					rB += d[1][moveB[i] - 1][0];
					cB += d[1][moveB[i] - 1][1];
				}
				if (map[cA][rA].isEmpty() && map[cB][rB].isEmpty())
					continue;
				else if (map[cA][rA].isEmpty())
					ans += BC[map[cB][rB].get(0)][3];
				else if (map[cB][rB].isEmpty())
					ans += BC[map[cA][rA].get(0)][3];
				else {
					if (map[cA][rA].get(0) == map[cB][rB].get(0)) {
						ans += BC[map[cA][rA].get(0)][3];
						if (map[cA][rA].size() > 1 && map[cB][rB].size() > 1) {
							if (BC[map[cA][rA].get(1)][3] >= BC[map[cB][rB].get(1)][3])
								ans += BC[map[cA][rA].get(1)][3];
							else
								ans += BC[map[cB][rB].get(1)][3];
						} else if (map[cA][rA].size() > 1)
							ans += BC[map[cA][rA].get(1)][3];
						else if (map[cB][rB].size() > 1)
							ans += BC[map[cB][rB].get(1)][3];
					} else {
						ans += BC[map[cA][rA].get(0)][3];
						ans += BC[map[cB][rB].get(0)][3];
					}
				}
			}
			sb.append("#").append(TC).append(" ").append(ans).append("\n");
		} // end of testcase
		System.out.print(sb.toString());
	} // end of main
} // end of class