package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1967_트리의지름_G4_이선민_160ms {

	static class Node {
		int vertex, weight;
		Node link;

		public Node(int vertex, int weigth, Node link) {
			super();
			this.vertex = vertex;
			this.weight = weigth;
			this.link = link;
		}

	} // end of Node class

	static int farestNode, ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 노드의 개수(1 ≤ n ≤ 10,000)
		StringTokenizer st;
		Node[] tree = new Node[n + 1]; // 인접리스트
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n1 = Integer.parseInt(st.nextToken()); // 부모노드
			int n2 = Integer.parseInt(st.nextToken()); // 자식노드
			int w = Integer.parseInt(st.nextToken()); // 간선의 가중치(0 < w ≤ 100)
			// 양방향 저장(자식노드로부터 부모노드로 올라오기위해)
			tree[n1] = new Node(n2, w, tree[n1]);
			tree[n2] = new Node(n1, w, tree[n2]);
		}

		boolean[] visited = new boolean[n+1];
		dfs(tree, visited, n, 1, 0);	// 루트노드에서 가장 먼 정점(farest) 구하기
		
		visited = new boolean[n+1];
		dfs(tree, visited, n, farestNode, 0);	// farest에서 가장 먼 정점 구하기
		
		System.out.print(ans);

	} // end of main

	private static void dfs(Node[] tree, boolean[] visited, int n, int current, int tempLength) {	// current: 현재 정점번호, tempLength: 출발노드로부터 현재노드까지의 거리
		if (tempLength > ans) { // 출발노드로부터 가장 멀리있는 노드의 번호와 길이 갱신
			ans = tempLength;
			farestNode = current;
		}

		visited[current] = true;
		for (Node temp = tree[current]; temp != null; temp = temp.link) {
			if(!visited[temp.vertex]) {
				dfs(tree, visited, n, temp.vertex, tempLength + temp.weight);
			}
		}
	} // end of dfs
	
} // end of class
