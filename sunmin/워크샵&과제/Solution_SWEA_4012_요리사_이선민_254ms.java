import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_4012_요리사_이선민_254ms {

	private static int N, answer;
	private static int[][] synergy;
	private static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine()); // 식재료의 개수(4 ≤ N ≤ 16, N은 짝수)

			synergy = new int[N][N]; // N * N개의 시너지 S_ij값 (1 ≤ S_ij ≤ 20000, i ≠ j)
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			answer = Integer.MAX_VALUE; // 두 음식간 맛의 차이
			visited = new boolean[N];
			comb(0, 0);

			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		} // end of testcase
		System.out.print(sb);
	} // end of main

	// 식재료 조합 추출
	private static void comb(int cnt, int start) {		
		if (cnt == N / 2) {
			int food1 = 0, food2 = 0; // 각 음식의 시너지 합
			
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (visited[i] && visited[j]) { // 첫번째 음식의 재료들
						food1 += synergy[i][j] + synergy[j][i];
					} else if (!visited[i] && !visited[j]) { // 두번째 음식의 재료들
						food2 += synergy[i][j] + synergy[j][i];
					}
					
				}
			}

			// 맛의 차이가 더 작은값 저장
			answer = Math.abs(food1 - food2) < answer ? Math.abs(food1 - food2) : answer;

			return;
		}

		for (int i = start; i < N; i++) {
			visited[i] = true;
			comb(cnt + 1, i + 1);
			visited[i] = false;
		}
	} // end of comb

} // end of class
