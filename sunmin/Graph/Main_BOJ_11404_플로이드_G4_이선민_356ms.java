package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_11404_플로이드_G4_이선민_356ms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 도시의 개수(2 ≤ n ≤ 100)
		int m = Integer.parseInt(br.readLine()); // 버스의 개수(1 ≤ m ≤ 100,000)
		StringTokenizer st;
		int[][] adjMatrix = new int[n + 1][n + 1];
		int INF = 100000 * n;
		for (int[] arr : adjMatrix) {
			Arrays.fill(arr, INF); // 이어지지 않은 정점과 자신노드 구분하기 위해
		}
		for (int i = 1; i <= n; i++) {
			adjMatrix[i][i] = 0; // 자기노드에서 자기노드로 가는 최소비용
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int pay = Integer.parseInt(st.nextToken());
			if (adjMatrix[from][to] > pay) { // 두 정점을 잇는 여러 간선 중 최소비용인것만 저장
				adjMatrix[from][to] = pay;
			}
		}

		// 플로이드 워셜
		// i에서 j로 가는데 k를 거쳐가는게 더 빠르다면 갱신해줌
		for (int k = 1; k <= n; k++) {	// 모든 노드를 k로 설정해가면서 탐색
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					adjMatrix[i][j] = Math.min(adjMatrix[i][k] + adjMatrix[k][j], adjMatrix[i][j]);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(adjMatrix[i][j]==INF) {
					sb.append("0 ");
				} else {
					sb.append(adjMatrix[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	} // end of main

} // end of class
