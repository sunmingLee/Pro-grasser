package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_1167_트리의지름_G3_이선민_560ms {
	static class Node {
		int vertex; // 정점 번호
		int weight; // 간선의 가중치
		Node link;

		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}

		public Node(int vertex, int weight, Node link) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.link = link;
		}

	} // end of Node class

	static int ans, farest;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int V = Integer.parseInt(br.readLine()); // 정점의 개수(2 ≤ V ≤ 100,000)
		Node[] tree = new Node[V + 1]; // 간선 정보
//		List<Node>[] list = new ArrayList[V+1];

		for (int i = 1; i <= V; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int vNum = Integer.parseInt(st.nextToken()); // 정점의 번호
			while (st.hasMoreTokens()) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == -1) {
					break;
				}
				int v = temp; // 이어진 정점번호
				int w = Integer.parseInt(st.nextToken()); // 정점까지의 거리
				tree[vNum] = (new Node(v, w, tree[vNum]));
			}
		} // 간선 정보 저장 완료

		boolean[] visited = new boolean[V + 1];
		dfs(tree, visited, 1, 0);
		
		visited = new boolean[V + 1];
		dfs(tree, visited, farest, 0);
		
		System.out.print(ans);

	} // end of main

	private static void dfs(Node[] tree, boolean[] visited, int current, int length) {
		if (length > ans) {
			ans = length;
			farest = current;
		}
		
		visited[current] = true;
		for (Node temp = tree[current]; temp != null; temp = temp.link) {
			if (!visited[temp.vertex]) {
				dfs(tree, visited, temp.vertex, length + temp.weight);
//				visited[temp.vertex] = true;
			}
//			visited[current] = false;
		}

//		ans = Math.max(length, ans); // 가장 거리가 긴 값을 ans로
	} // end of dfs
} // end of class
