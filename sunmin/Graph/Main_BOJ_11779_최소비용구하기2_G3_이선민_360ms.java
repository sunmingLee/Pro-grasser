package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BOJ_11779_최소비용구하기2_G3_이선민_360ms {
	static class Node implements Comparable<Node> {
		int vertex, weight;
		Node link;

		public Node(int vertex, int weight, Node link) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.link = link;
		}

		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}

	} // end of Node class

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 도시 개수(1≤n≤1,000)
		int m = Integer.parseInt(br.readLine()); // 버스 개수(1≤m≤100,000)
		StringTokenizer st;
		Node[] adjList = new Node[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, w, adjList[from]);
		}
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken()); // 출발 도시
		int end = Integer.parseInt(st.nextToken()); // 도착 도시

		// dijkstra
		int[] money = new int[n + 1]; // 해당 인덱스의 도시까지 오는데 드는 최소비용
		Arrays.fill(money, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		boolean[] visited = new boolean[n + 1];
		int[] way = new int[n + 1]; // 해당 인덱스의 도시까지 오는 경로
		pq.offer(new Node(start, 0));
		money[start] = 0;
		way[start] = 0;
		while (!pq.isEmpty()) {
			Node current = pq.poll();
			if (visited[current.vertex]) {
				continue;
			}
			visited[current.vertex] = true;

			for (Node temp = adjList[current.vertex]; temp != null; temp = temp.link) {
				int tempMoney = money[current.vertex] + temp.weight;
				if (money[temp.vertex] > tempMoney) {
					money[temp.vertex] = tempMoney;
					pq.offer(new Node(temp.vertex, money[temp.vertex]));
					way[temp.vertex] = current.vertex; // 다음 정점(temp.vertex)의 이전 정점(current.vertex)를 저장
				}

			}
		} // end of dijkstra

		StringBuilder sb = new StringBuilder();
		sb.append(money[end]).append("\n");
		
		// 도착 도시부터 거꾸로 올라가면서 거쳐가는 도시를 스택에 담아줌
		int now = end;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(now);
		while(now!=start) {
			stack.push(way[now]);
			now = way[now];
		}
		
		int size = stack.size();
		sb.append(size).append("\n");
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(sb.toString());
	} // end of main

} // end of class
