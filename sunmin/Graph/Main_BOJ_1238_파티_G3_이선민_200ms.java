package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_1238_파티_G3_이선민_200ms {

	static class Vertex implements Comparable<Vertex> {
		int no; // 마을번호
		int minDistance; // 출발지에서 자신으로의 최소비용

		public Vertex(int no, int minDistance) {
			super();
			this.no = no;
			this.minDistance = minDistance;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.minDistance - o.minDistance;
		}

	} // end of Vertex class

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 학생의 수(1 ≤ N ≤ 1,000)
		int M = Integer.parseInt(st.nextToken()); // 단방향 도로의 수(1 ≤ M ≤ 10,000)
		int X = Integer.parseInt(st.nextToken()); // 모이기로 한 마을의 번호(1 ≤ X ≤ N)

		int[][] adjMatrix = new int[N + 1][N + 1]; // 인접행렬
		// 도로정보 행렬에 저장
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()); // 출발마을
			int to = Integer.parseInt(st.nextToken()); // 도착마을
			int time = Integer.parseInt(st.nextToken()); // 도로를 지나는데 걸리는 시간(1 ≤ time ≤ 100)
			adjMatrix[from][to] = time;
		}

		int[] go = new int[N + 1]; // 각자 마을에서 모이기로 한 마을까지의 최소거리
		int[] back = new int[N + 1]; // 출발지에서 자신으로 오는 최소거리
		Arrays.fill(back, Integer.MAX_VALUE); // 직접 갈 수 없는 마을도 0으로 표기되어있기때문에 Integer.MAX_VALUE값으로 초기화
		Arrays.fill(go, Integer.MAX_VALUE);

		dijkstraGo(N, X, go, adjMatrix);	
		dijkstraBack(N, X, back, adjMatrix); // 모이기로 한 마을에서 각자 마을까지의 최소 거리 계산

		int ans = 0; // 왕복 시 가장 오래 걸린 시간
		for (int i = 1; i <= N; i++) {
			ans = Math.max(ans, go[i] + back[i]);
		}
		System.out.print(ans);
	} // end of main

	/**
	 * 자기 마을에서 모이기로 한 마을까지의 최소거리 계산
	 */
	private static void dijkstraGo(int N, int start, int[] distance, int[][] adjMatrix) {
		boolean[] visited = new boolean[N + 1]; // 최소비용 확정되었으면 true
		PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>();

		distance[start] = 0; // 시작마을 0으로
		pQueue.offer(new Vertex(start, distance[start]));

		while (!pQueue.isEmpty()) {
			// 1단계 : 최소비용이 확정되지 않은 정점 중 최소비용의 정점 선택
			Vertex current = pQueue.poll();
			if (visited[current.no]) { // 현재 정점이 이미 최소비용이 확정된 경우,
				continue;
			}
			visited[current.no] = true; // 최소비용 확정된 정점

			// 2단계 : 선택된 정점을 경유지로 하여 아직 최소비용이 확정되지 않은 다른 정점의 최소비용을 고려
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && adjMatrix[i][current.no] != 0
						&& distance[i] > distance[current.no] + adjMatrix[i][current.no]) { // 경유해 오는게 직접비용보다 작다면
					distance[i] = distance[current.no] + adjMatrix[i][current.no];
					pQueue.offer(new Vertex(i, distance[i]));
				}
			}
		}
	} // end of dijkstra
	
	/**
	 * 모이기로 한 마을에서 자기 마을까지 최소거리 계산
	 */
	private static void dijkstraBack(int N, int start, int[] distance, int[][] adjMatrix) {
		boolean[] visited = new boolean[N + 1]; // 최소비용 확정되었으면 true
		PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>();
		
		distance[start] = 0; // 시작마을 0으로
		pQueue.offer(new Vertex(start, distance[start]));
		
		while (!pQueue.isEmpty()) {
			// 1단계 : 최소비용이 확정되지 않은 정점 중 최소비용의 정점 선택
			Vertex current = pQueue.poll();
			if (visited[current.no]) { // 현재 정점이 이미 최소비용이 확정된 경우,
				continue;
			}
			visited[current.no] = true; // 최소비용 확정된 정점
			
			// 2단계 : 선택된 정점을 경유지로 하여 아직 최소비용이 확정되지 않은 다른 정점의 최소비용을 고려
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && adjMatrix[current.no][i] != 0
						&& distance[i] > distance[current.no] + adjMatrix[current.no][i]) { // 경유해 오는게 직접비용보다 작다면
					distance[i] = distance[current.no] + adjMatrix[current.no][i];
					pQueue.offer(new Vertex(i, distance[i]));
				}
			}
		}
	} // end of dijkstra

} // end of class
