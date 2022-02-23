import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_7465_창용마을무리의개수_D4_이선민_145ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 창용 마을에 사는 사람의 수(1 ≤ N ≤ 100)
			int M = Integer.parseInt(st.nextToken()); // 서로를 알고 있는 사람의 관계 수(0 ≤ M ≤ N(N-1)/2)

			int[] parents = new int[N + 1]; // 대표자를 담을 배열
			makeSet(N, parents); // 단위집합 생성

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken()); // 서로 알고있는 마을사람1
				int b = Integer.parseInt(st.nextToken()); // 서로 알고있는 마을사람2
				union(a, b, parents);
			} // 사람들간의 관계 정리 종료

			boolean[] rep = new boolean[N + 1]; // 대표자
			for (int i = 1; i <= N; i++) {
				rep[findSet(i, parents)] = true;
			}

			int ans = 0; // 무리의 개수
			for (int i = 1; i <= N; i++) {
				if (rep[i]) {
					ans++;
				}
			}

			sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		} // end of testcase
		System.out.print(sb);
	} // end of main

	private static void union(int a, int b, int[] parents) {
		int aRoot = findSet(a, parents);
		int bRoot = findSet(b, parents);
		if (aRoot != bRoot) { // 두 원소가 같은 집합에 속해있지 않다면
			parents[aRoot] = bRoot;
		}
	} // end of union

	private static int findSet(int a, int[] parents) {
		if (parents[a] == a) {
			return a;
		}

		return parents[a] = findSet(parents[a], parents);
	} // end of findSet

	private static void makeSet(int N, int[] parents) {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	} // end of makeSet

} // end of class
