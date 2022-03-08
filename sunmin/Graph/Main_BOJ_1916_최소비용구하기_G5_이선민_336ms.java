package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_1916_최소비용구하기_G5_이선민_336ms {

	static class Node implements Comparable<Node> {
		int vertex;
		int weight;
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
		int N = Integer.parseInt(br.readLine()); // 도시의 개수(1 ≤ N ≤ 1,000)
		int M = Integer.parseInt(br.readLine()); // 버스의 개수(1 ≤ M ≤ 100,000)
		StringTokenizer st;
		Node[] adjList = new Node[N + 1]; // 인접리스트
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()); // 버스가 출발하는 도시
			int to = Integer.parseInt(st.nextToken()); // 버스가 도착하는 도시
			int w = Integer.parseInt(st.nextToken()); // 버스 비용(0 ≤ M < 100,000)
			adjList[from] = new Node(to, w, adjList[from]);
		}

		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken()); // 출발 도시
		int end = Integer.parseInt(st.nextToken()); // 도착 도시

		System.out.print(dijkstra(adjList, N, start, end));

	} // end of main

	private static int dijkstra(Node[] adjList, int N, int start, int end) {
		PriorityQueue<Node> pQueue = new PriorityQueue<Node>();
		boolean[] visited = new boolean[N + 1];
		int[] distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		pQueue.offer(new Node(start, distance[start]));

		int result = 0; // 도착 도시까지의 최소비용
		while (!pQueue.isEmpty()) {
			int current = pQueue.poll().vertex;
			if (current == end) {
				result = distance[current];
				break;
			}

			if (visited[current]) {
				continue;
			}
			visited[current] = true;

			for (Node temp = adjList[current]; temp != null; temp = temp.link) {
				if (!visited[temp.vertex] && distance[temp.vertex] > distance[current] + temp.weight) {
					distance[temp.vertex] = distance[current] + temp.weight;
					pQueue.offer(new Node(temp.vertex, distance[temp.vertex]));
				}
			}
		}

		return result;
	} // end of dijkstra

} // end of class
