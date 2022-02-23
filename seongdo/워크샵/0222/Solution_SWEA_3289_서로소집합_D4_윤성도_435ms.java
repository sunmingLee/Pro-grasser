package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3289_서로소집합_D4_윤성도_435ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int TC = 1; TC <= T; TC++) {
			sb.append("#").append(TC).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] chk = new int[n+1];
			for(int i = 1; i <= n; i++) chk[i] = i;
			
			while(m-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");
				String command = st.nextToken();
				int a = root(chk, Integer.parseInt(st.nextToken()));
				int b = root(chk, Integer.parseInt(st.nextToken()));
				switch(command.charAt(0)) {
				case '0':
					if(a != b) chk[b] = a;
					break;
				case '1':
					if(a == b) sb.append(1);
					else sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static public int root(int[] chk, int a) {
		if(chk[a]==a) return a;
		return chk[a] = root(chk, chk[a]);
	}
}