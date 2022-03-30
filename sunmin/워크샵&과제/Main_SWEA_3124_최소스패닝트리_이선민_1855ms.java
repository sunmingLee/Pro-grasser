import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_SWEA_3124_최소스패닝트리_이선민_1855ms {
	static class Node implements Comparable<Node> {
		int vertex, weight;
		Node link;

		public Node(int vertex, int weight, Node link) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.link = link;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	} // end of Node class

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= TC; test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			int nodeNum = Integer.parseInt(st.nextToken());
			int edgeNum = Integer.parseInt(st.nextToken());
			Node[] adjList = new Node[nodeNum + 1];
			for (int i = 0; i < edgeNum; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				// 양방향 저장
				adjList[from] = new Node(to, w, adjList[from]);
				adjList[to] = new Node(from, w, adjList[to]);
			}

			long ans = 0;
			int cnt = 0;
			boolean[] visited = new boolean[nodeNum + 1];
			PriorityQueue<Node> pq = new PriorityQueue<Node>();
			pq.offer(new Node(1, 0, null));
			while (!pq.isEmpty()) {
				Node current = pq.poll();
				if (visited[current.vertex]) {
					continue;
				}
				visited[current.vertex] = true;
				ans += current.weight;
				if (++cnt == nodeNum) {
					break;
				}
				for (Node temp = adjList[current.vertex]; temp != null; temp = temp.link) {
					if (visited[temp.vertex]) {
						continue;
					}
					pq.offer(new Node(temp.vertex, temp.weight, null));
				}
			}

			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		} // end of test_case
		System.out.print(sb.toString());
	}

}
