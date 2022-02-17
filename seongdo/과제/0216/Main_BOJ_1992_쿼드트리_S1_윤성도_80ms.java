package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_1992_쿼드트리_S1_윤성도_80ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[][] map = new int[N][N];
		for(int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		process(map, 0, N, 0, N, sb);
		System.out.println(sb.toString());
	}

	private static void process(int[][] map, int iS, int iE, int jS, int jE, StringBuilder sb) {
		int chk = map[iS][jS];
esc:	for(int i = iS; i < iE; i++) {
			for(int j = jS; j < jE; j++) {
				if(map[i][j] != chk) {
					chk = -1;
					break esc;
				}
			}
		}
		if(chk!=-1) {
			sb.append(chk - '0');
			return;
		}
		int iM = (iS + iE) / 2, jM = (jS + jE) / 2;
		sb.append("(");
		process(map, iS, iM, jS, jM, sb);
		process(map, iS, iM, jM, jE, sb);
		process(map, iM, iE, jS, jM, sb);
		process(map, iM, iE, jM, jE, sb);
		sb.append(")");
	}
}