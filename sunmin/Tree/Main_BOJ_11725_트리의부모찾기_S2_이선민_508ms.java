package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.
 */
public class Main_BOJ_11725_트리의부모찾기_S2_이선민_508ms {

	static int node;
	static int[] tree;
	static boolean[] visited;
	static ArrayList[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); // 노드의 개수(2 ≤ N ≤ 100,000)

		tree = new int[N + 1]; // 부모 노드 번호를 담을 배열(크기를 N+1로 정해 인덱스번호를 노드번호로 사용)
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		int a, b;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			// 연결된 두 정점을 잠시 담아둘 변수
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);

		}

		visited = new boolean[N + 1];
		dfs(1);

		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			sb.append(tree[i]).append("\n");
		}
		System.out.print(sb);
	} // end of main

	private static void dfs(int i) {
		visited[i] = true;

		for (int j = 0; j < list[i].size(); j++) {
			node = (int) list[i].get(j); // 현재 확인하려는 노드
			if (!visited[node]) { // 방문하지 않은 노드라면
				tree[node] = i;
				dfs(node);
			}
		}
	}

} // end of class
