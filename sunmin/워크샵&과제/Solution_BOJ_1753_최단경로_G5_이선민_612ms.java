import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_BOJ_1753_최단경로_G5_이선민_612ms {

	static class Vertex implements Comparable<Vertex> {
		int no; // 정점번호
		int minDistance; // 출발지에서 자신으로의 최소비용

		public Vertex(int no, int minDistance) {
			super();
			this.no = no;
			this.minDistance = minDistance;
		}

		@Override
		public int compareTo(Vertex o) { // 오름차순 정렬
			return this.minDistance - o.minDistance;
		}
	} // end of Vertex

	static class Node {
		int vertex;
		int weight;
		Node link;

		public Node(int vertex, int weight, Node link) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.link = link;
		}

	} // end of Node class

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());

		// 인접리스트
		Node[] adjList = new Node[V + 1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, weight, adjList[from]);
		}

		int[] distance = new int[V + 1];
		boolean[] visited = new boolean[V + 1];
		PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>();

		Arrays.fill(distance, Integer.MAX_VALUE); // input으로 받을때 직접 갈수 없는곳도 0으로 표기되어있기때문에 max값으로 초기화
		distance[start] = 0;
		pQueue.offer(new Vertex(start, distance[start]));

		while(!pQueue.isEmpty()) {
			// 1단계 : 최소비용이 확정되지 않은 정점 중 최소비용의 정점 선택
			Vertex current = pQueue.poll();
			if(visited[current.no]) {	// 현재 정점이 이미 최소비용이 확정된 경우,
				continue;
			}
			visited[current.no] = true; // 최소비용 확정된 정점

			// 2단계 : 선택된 정점을 경유지(w)로 하여 아직 최소비용이 확정되지 않은 다른 정점의 최소비용을 고려
			for (Node temp = adjList[current.no]; temp != null; temp = temp.link) {
				if (!visited[temp.vertex] && distance[temp.vertex] > distance[current.no] + temp.weight) {
					distance[temp.vertex] = distance[current.no] + temp.weight;
					pQueue.offer(new Vertex(temp.vertex, distance[temp.vertex]));
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if (distance[i] == Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
				continue;
			}
			sb.append(distance[i]).append("\n");
		}
		System.out.print(sb.toString());

	} // end of main

}
