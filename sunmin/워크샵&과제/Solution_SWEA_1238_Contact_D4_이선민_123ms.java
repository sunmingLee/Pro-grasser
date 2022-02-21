import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Solution_SWEA_1238_Contact_D4_이선민_123ms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int test_case = 0;
		while ((line = br.readLine()) != null) { // 더이상 입력값이 없을때까지
			test_case++;
			st = new StringTokenizer(line, " ");
			int dlength = Integer.parseInt(st.nextToken()); // 입력 받는 데이터의 길이
			int startNode = Integer.parseInt(st.nextToken()); // 연락을 시작하는 당번

			int[][] adjMatrix = new int[101][101]; // 그래프 정보를 담을 인접행렬(정점번호와 같도록 크기를 100+1로 설정)
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < dlength / 2; i++) { // 한번에 출발정점과 도착정점 모두를 처리하므로 dlength/2번 실행
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				adjMatrix[from][to] = 1;
			}

			sb.append("#").append(test_case).append(" ").append(bfs(adjMatrix, startNode)).append("\n");
		} // end of while

		System.out.print(sb);
	} // end of main

	private static int bfs(int[][] adjMatrix, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] visited = new int[101]; // 몇번째로 방문했는지 체크

		queue.offer(start);
		visited[start] = 1;

		int ans = 0, maxCnt = 0;
		while (!queue.isEmpty()) {
			int current = queue.poll();

			// current정점의 인접정점 처리
			for (int i = 1; i <= 100; i++) {
				if (visited[i] != 0 || adjMatrix[current][i] != 1) { // 인접하지 않았거나 방문한적 있으면 pass
					continue;
				}
				queue.offer(i);
				visited[i] = visited[current] + 1;
			}

			maxCnt = visited[current];	// 연락받은 순서(클수록 뒤에 연락을 받음)
		}

		for (int i = 1; i <= 100; i++) {
			if (maxCnt != visited[i]) {
				continue;
			}
			ans = ans > i ? ans : i; // 마지막으로 연락받은 사람 중 숫자가 가장 큰 사람
		}

		return ans;
	} // end of bfs

} // end of class
