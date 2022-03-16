package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_1865_웜홀_G3_이선민_412ms {

	static class Node {
		int from;
		int to;
		int weight;

		public Node(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

	} // end of Node class

	static final int INF = 2500 * 10000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine()); // 테스트 케이스 개수(1 ≤ TC ≤ 5)
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= TC; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 지점의 수(1 ≤ N ≤ 500)
			int M = Integer.parseInt(st.nextToken()); // 도로의 수(1 ≤ M ≤ 2500)
			int W = Integer.parseInt(st.nextToken()); // 웜홀의 수(1 ≤ W ≤ 200)

			List<Node> list = new ArrayList<Node>();
			// 도로 저장
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken()); // 출발지점
				int to = Integer.parseInt(st.nextToken()); // 도착지점
				int time = Integer.parseInt(st.nextToken()); // 도로를 지나는데 걸리는 시간
				// 양방향 저장
				list.add(new Node(from, to, time));
				list.add(new Node(to, from, time));
			}

			// 웜홀 저장
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken()); // 출발지점
				int to = Integer.parseInt(st.nextToken()); // 도착지점
				int time = Integer.parseInt(st.nextToken()); // 웜홀을 지나는데 줄어드는 시간(0≤time<10,000)
				list.add(new Node(from, to, -time));
			}

			if (bellmanFord(list, N, 1)) { // 음의 사이클이 존재하는 경우
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		} // end of test_case

		System.out.print(sb.toString());
	} // end of main

	/**
	 * 음의 사이클이 존재하는 경우 true
	 */
	private static boolean bellmanFord(List<Node> list, int N, int start) {
		int[] distance = new int[N + 1];
		Arrays.fill(distance, INF);
		distance[start] = 0; // start 지점에서 출발

		// 지점의개수만큼 최단거리 초기화
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < list.size(); j++) {
				if (distance[list.get(j).to] > distance[list.get(j).from] + list.get(j).weight) {
					if (i == N) { // N번째에도 최단거리가 갱신된다면, 음의 사이클이 존재함
						return true;
					}
					distance[list.get(j).to] = distance[list.get(j).from] + list.get(j).weight;
				}
			}
		}

		return false;

	} // end of bellmanFord

} // end of class
