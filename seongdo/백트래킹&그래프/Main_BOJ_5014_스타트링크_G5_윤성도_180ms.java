package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_5014_스타트링크_G5_윤성도_180ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		boolean[] visit = new boolean[F + 1];
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(S);
		visit[S] = true;
		int depth = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				if (cur == G) {
					System.out.print(depth);
					return;
				}
				if (cur + U <= F && !visit[cur + U]) {
					visit[cur + U] = true;
					q.offer(cur + U);
				}
				if (cur - D > 0 && !visit[cur - D]) {
					visit[cur - D] = true;
					q.offer(cur - D);
				}
			}
			depth++;
		}
		System.out.print("use the stairs");
	}
}