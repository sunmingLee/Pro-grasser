package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_7465_창용마을무리의개수_D4_윤성도_126ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int TC = 1; TC <= T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] num = new int[N+1];
			boolean[] chk = new boolean[N+1];
			for(int i = 1; i <= N; i++) {
				num[i] = i;
				chk[i] = true;
			}
			while(M-->0) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = root(num, Integer.parseInt(st.nextToken()));
				int b = root(num, Integer.parseInt(st.nextToken()));
				if(a==b) continue;
				num[b] = a;
				chk[b] = false;
			}
			int ans = 0;
			for(int i = 1; i <= N; i++) if(chk[i]) ans++;
			sb.append("#").append(TC).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
	static public int root(int[] chk, int a) {
		if(chk[a]==a) return a;
		return chk[a] = root(chk, chk[a]);
	}
}