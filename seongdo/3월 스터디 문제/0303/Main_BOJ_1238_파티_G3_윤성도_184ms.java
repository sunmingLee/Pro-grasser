package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_1238_파티_G3_윤성도_184ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		Node[] adj1 = new Node[N + 1];
		Node[] adj2 = new Node[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adj1[from] = new Node(to, weight, adj1[from]);
			adj2[to] = new Node(from, weight, adj2[to]);
		}
		int[] d1 = new int[N + 1];
		int[] d2 = new int[N + 1];
		d1[X] = d2[X] = -1;
		dijkstra(d1, adj1, X);
		dijkstra(d2, adj2, X);
		int ans = 0;
		for (int i = 1; i <= N; i++)
			if (d1[i] + d2[i] > ans)
				ans = d1[i] + d2[i];
		System.out.print(ans);
	}
	
	static void dijkstra(int[] d, Node[] adj, int X) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		for (Node node = adj[X]; node != null; node = node.next)
			q.offer(node);
		while (!q.isEmpty()) {
			Node cur = q.poll();
			if (d[cur.to] != 0)
				continue;
			d[cur.to] = cur.w;
			for (Node node = adj[cur.to]; node != null; node = node.next) {
				if (d[node.to] != 0)
					continue;
				q.offer(new Node(node.to, cur.w + node.w));
			}
		}
	}

	static class Node implements Comparable<Node> {
		int to, w;
		Node next;

		public Node(int to, int w, Node next) {
			super();
			this.to = to;
			this.w = w;
			this.next = next;
		}

		public Node(int to, int w) {
			super();
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return w - o.w;
		}
	}
}
