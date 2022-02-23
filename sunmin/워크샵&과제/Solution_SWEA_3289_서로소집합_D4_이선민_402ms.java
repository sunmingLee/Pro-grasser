import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3289_서로소집합_D4_이선민_402ms {

	static int n;
	static int[] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");

			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken()); // 초기집합의 개수
			int m = Integer.parseInt(st.nextToken()); // 연산의 개수

			makeSet(); // 단위 집합 생성

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int order = Integer.parseInt(st.nextToken()); // 수행할 연산번호
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				switch (order) {
				case 0: // union
					union(x, y);
					break;
				case 1: // find_set
					if (findSet(x) == findSet(y)) { // 두 원소의 대표자가 같다면
						sb.append(1);
					} else {
						sb.append(0);
					}
					break;
				default:
					break;
				}
			} // 연산 종료

			sb.append("\n");
		} // end of testcase

		System.out.print(sb);
	} // end of main

	/** 단위 집합 생성 */
	public static void makeSet() {
		parents = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	} // end of makeSet

	/** a의 대표자 찾기 */
	private static int findSet(int a) {
		if (a == parents[a]) { // 내가 나의 부모인 경우
			return a;
		}
		return parents[a] = findSet(parents[a]); // path compression(나의 부모를 root 노드로 바꿔줌)
	} // end of findSet

	/** a, b 두 집합 합치기 */
	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) { // 두 집합의 부모가 같을 경우
			return false;
		}

		parents[bRoot] = aRoot;
		return true;
	} // end of union

} // end of class
