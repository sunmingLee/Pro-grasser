package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1238_Contact_D4_윤성도_118ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int TC = 1; TC <= 10; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
			for(int i = 0; i <= N; i++) adj.add(new ArrayList<Integer>());
			st = new StringTokenizer(br.readLine(), " ");
			while(st.hasMoreTokens()) adj.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
			
			// BFS 탐색
			Queue<Integer> q = new ArrayDeque<>();
			boolean[] visit = new boolean[N+1];
			int ans = 0;
			q.add(S);
			visit[S] = true;
			while(!q.isEmpty()) {
				int size = q.size();
				ans = 0;
				while(size-->0) {
					int num = q.poll();
					for(int i : adj.get(num)) {
						if(visit[i]) continue;
						visit[i] = true;
						q.add(i);
					}
					if(ans < num) ans = num;
				}
			}
			sb.append("#").append(TC).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
}
