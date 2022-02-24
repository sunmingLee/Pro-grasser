import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_JUNGOL_1681_해밀턴순환회로_이선민_137ms {

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

	static int answer = Integer.MAX_VALUE; // 모든 장소를 거치는 최소비용

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 배달해야 하는 장소의 수(1≤N≤13)
		StringTokenizer st;

		// input으로 들어오는 인접행렬을 인접리스트로 변환
		Node[] adjList = new Node[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int w = Integer.parseInt(st.nextToken()); // 간선의 가중치
				if (w == 0) {
					continue;
				}
				adjList[i] = new Node(j, w, adjList[i]);
			}
		}

		boolean[] visited = new boolean[N];
		dfs(adjList, visited, 1, 0, 0); // 언제나 회사(0번정점)에서 출발
		System.out.print(answer);

	} // end of main

	private static void dfs(Node[] adjList, boolean[] visited, int cnt, int current, int money) {
		if (money > answer) {
			return;
		}

		if (cnt == visited.length) { // 모든 지역을 방문했고
			for (Node temp = adjList[current]; temp != null; temp = temp.link) { // 해당 정점의 인접정점들을 모두 탐색
				if (temp.vertex == 0) { // 회사로 돌아가는 길이 있다면
					money += temp.weight;
					answer = answer > money ? money : answer; // 최소비용 갱선
					break;
				}
			}
			return;
		}

		visited[current] = true;
		for (Node temp = adjList[current]; temp != null; temp = temp.link) {
			if (!visited[temp.vertex]) {
				dfs(adjList, visited, cnt + 1, temp.vertex, money + temp.weight);
				visited[temp.vertex] = false;
			}
		}

	} // end of dfs

} // end of class
