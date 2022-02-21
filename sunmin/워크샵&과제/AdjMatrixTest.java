import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
7
8
0 1
0 2
1 3
1 4
2 4
3 5
4 5
5 6

 */

/**
 * 무향그래프
 *
 */
public class AdjMatrixTest {
	static int N;

	static class Node {
		int vertex;
		Node link;

		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}

	} // end of Node class

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점 수
		int C = sc.nextInt(); // 간선 수

		int[][] adjMatrix = new int[N][N]; // 인접행렬
		Node[] adjList = new Node[N]; // 인접리스트

		for (int i = 0; i < C; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();

			// 무향이므로 간선 하나로 양방향 처리
			adjMatrix[to][from] = adjMatrix[from][to] = 1;
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}

//		bfs(adjMatrix, 0);
//		bfs(adjList, 0);
//		dfs(adjMatrix, new boolean[N], 0);
		dfs(adjList, new boolean[N], 0);
	} // end of main

//	public static void dfs(int[][] adjMatrix, boolean[] visited, int current) {
//		visited[current] = true;
//		System.out.println(current);
//
//		// current정점의 인접정점 처리(단, 방문하지 않은 인접정점만)
//		for (int i = 0; i < N; i++) {
//			if (!visited[i] && adjMatrix[current][i] != 0) {
//				dfs(adjMatrix, visited, i);
//			}
//		}
//
//	} // end of dfs using int[][]

	public static void dfs(Node[] adjList, boolean[] visited, int current) {
		visited[current] = true;
		System.out.println(current);

		// current정점의 인접정점 처리(단, 방문하지 않은 인접정점만)
		for (Node temp = adjList[current]; temp != null; temp = temp.link) { // temp: 현재 정점의 헤드
			if (!visited[temp.vertex]) {
				dfs(adjList, visited, temp.vertex);
			}
		}

	} // end of dfs using Node[]

//	public static void bfs(int[][] adjMatrix, int start) {
//		Queue<Integer> queue = new LinkedList<Integer>();
//		boolean[] visited = new boolean[N];
//
//		queue.offer(start);
//		visited[start] = true;
//
//		while (!queue.isEmpty()) {
//			int current = queue.poll();
//			System.out.println(current);
//
//			// current정점의 인접정점 처리(단, 방문하지 않은 인접정점만)
//			for (int i = 0; i < N; i++) {
//				if (!visited[i] && adjMatrix[current][i] != 0) {
//					queue.offer(i);
//					visited[i] = true;
//				}
//			}
//		}
//	} // end of bfs using int[][]

	public static void bfs(Node[] adjList, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];

		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println(current);

			// current정점의 인접정점 처리(단, 방문하지 않은 인접정점만)
			for (Node temp = adjList[current]; temp != null; temp = temp.link) { // temp: 현재 정점의 헤드
				if (!visited[temp.vertex]) {
					queue.offer(temp.vertex);
					visited[temp.vertex] = true;
				}
			}
		}
	} // end of bfs using Node[]

} // end of class
