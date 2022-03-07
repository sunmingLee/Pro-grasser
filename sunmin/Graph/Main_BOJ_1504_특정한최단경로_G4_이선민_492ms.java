package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_1504_특정한최단경로_G4_이선민_492ms {

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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 정점의 개수(2 ≤ N ≤ 800)
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수(0 ≤ E ≤ 200,000)

		// 간선이 존재하지 않는 경우
		if (E == 0) {
			System.out.print(-1);
			return;
		}

		Node[] adjList = new Node[N + 1]; // 인접리스트
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken()); // 간선의 가중치(1 ≤ w ≤ 1,000)
			// 양방향 도로 저장
			adjList[v1] = new Node(v2, w, adjList[v1]);
			adjList[v2] = new Node(v1, w, adjList[v2]);
		}

		st = new StringTokenizer(br.readLine(), " ");
		int v1 = Integer.parseInt(st.nextToken()); // 반드시 거쳐야하는 정점1
		int v2 = Integer.parseInt(st.nextToken()); // 반드시 거쳐야하는 정점2

		// 1->v1->v2->N
		int path1 = 0;
		path1 = dijkstra(adjList, N, 1, v1) + dijkstra(adjList, N, v1, v2) + dijkstra(adjList, N, v2, N);

		// 1->v2->v1->N
		int path2 = 0;
		path2 = dijkstra(adjList, N, 1, v2) + dijkstra(adjList, N, v2, v1) + dijkstra(adjList, N, v1, N);

		int ans = -1;
		if (path1 < Integer.MAX_VALUE || path2 < Integer.MAX_VALUE) {
			ans = Math.min(path1, path2);
		}
		System.out.print(ans);
	} // end of main

	private static int dijkstra(Node[] adjList, int N, int start, int end) { // start: 출발 정점, end: 목표(도착)정점
		PriorityQueue<Node> pQueue = new PriorityQueue<Node>();
		boolean[] visited = new boolean[N + 1]; // 최소비용 확정되었으면 true
		int[] distance = new int[N + 1]; // 출발정점에서 해당 인덱스번호의 정점까지의 최단거리
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		pQueue.offer(new Node(start, distance[start]));

		int result = 0; // 출발정점부터 목표정점까지의 최단거리
		while (!pQueue.isEmpty()) {
			int current = pQueue.poll().vertex;

			if (current == end) { // 원하는 정점에 도착했다면
				result = distance[current];
				break;
			}

			if (visited[current]) { // 현재 정점의 최소비용이 확정된 경우
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
