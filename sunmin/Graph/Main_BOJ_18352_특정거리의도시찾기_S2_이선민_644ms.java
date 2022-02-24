package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 어떤 나라에는 1번부터 N번까지의 도시와 M개의 단방향 도로가 존재한다. 모든 도로의 거리는 1이다.
 * 
 * 이 때 특정한 도시 X로부터 출발하여 도달할 수 있는 모든 도시 중에서, 최단 거리가 정확히 K인 모든 도시들의 번호를 출력하는 프로그램을
 * 작성하시오. 또한 출발 도시 X에서 출발 도시 X로 가는 최단 거리는 항상 0이라고 가정한다.
 *
 */
public class Main_BOJ_18352_특정거리의도시찾기_S2_이선민_644ms {

	static StringBuilder sb = new StringBuilder();

	static class Node {
		int vertex;
		Node link;

		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
	} // end of Node class

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 도시의 개수(2 ≤ N ≤ 300,000)
		int M = Integer.parseInt(st.nextToken()); // 도로의 개수(1 ≤ M ≤ 1,000,000)
		int K = Integer.parseInt(st.nextToken()); // 거리 정보( 1 ≤ K ≤ 300,000)
		int X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호(1 ≤ X ≤ N)

		Node[] adjList = new Node[N + 1]; // 인접리스트
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, adjList[from]);
		}

		int[] visited = new int[N + 1]; // 방문 및 출발도시로부터의 거리 체크
		search(adjList, visited, X, K);

		boolean flag = false;
		for (int i = 1; i <= N; i++) {
			if (visited[i] == K && i != X) { // 출발 도시에서 출발 도시로 가는 최단거리는 0이므로
				sb.append(i).append("\n");
				flag = true;
			}
		}

		// 조건을 만족하는 도시가 없다면
		if (!flag) {
			sb.append(-1);
		}

		System.out.print(sb.toString());

	} // end of main

	/**
	 * 출발 도시부터 bfs로 탐색
	 */
	private static void search(Node[] adjList, int[] visited, int X, int K) {
		Queue<Integer> queue = new ArrayDeque<Integer>();

		queue.offer(X);

		while (!queue.isEmpty()) {
			int current = queue.poll();
			
			if (visited[current] == K) {	// 원하는 거리에 있는 도시를 찾았다면 search 빠져나오기
				return;
			}

			// current 정점의 인접정점 처리(단, 방문하지 않은 인접정점만)
			for (Node temp = adjList[current]; temp != null; temp = temp.link) {
				if (visited[temp.vertex] == 0) { // 방문하지 않은 정점이라면
					queue.offer(temp.vertex);
					visited[temp.vertex] = visited[current] + 1; // 출발 도시로부터 현재 정점까지의 거리 +1을 해준게 새로 탐색할 정점의 깊이
				}
			}

		}

	} // end of search

} // end of class
