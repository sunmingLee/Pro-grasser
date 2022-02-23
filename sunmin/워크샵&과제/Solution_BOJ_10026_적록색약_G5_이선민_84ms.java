import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BOJ_10026_적록색약_G5_이선민_84ms {
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] arr = new char[N + 2][N + 2];
		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			for (int j = 1; j <= N; j++) {
				arr[i][j] = s.charAt(j - 1);
			}
		}

		boolean[][] visited = new boolean[N + 2][N + 2];
		// 적록색약이 아닌 사람
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (!visited[i][j]) {
					dfs(i, j, arr, visited);
					cnt++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append(" ");

		// 값 리셋
		cnt = 0;
		visited = new boolean[N + 2][N + 2];

		// 적록색약인 사람
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (!visited[i][j]) {
					newdfs(i, j, arr, visited);
					cnt++;
				}
			}
		}
		sb.append(cnt);
		System.out.print(sb.toString());

	} // end of main

	/**
	 * 적록색약 ver.
	 */
	private static void newdfs(int r, int c, char[][] arr, boolean[][] visited) {
		visited[r][c] = true;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (!visited[nr][nc]) {
				if (arr[r][c] == arr[nr][nc]) {
					newdfs(nr, nc, arr, visited);
				} else if ((arr[r][c] == 'R' || arr[r][c] == 'G') && (arr[nr][nc] == 'R' || arr[nr][nc] == 'G')) {
					newdfs(nr, nc, arr, visited);
				}
			}
		}
	} // end of newdfs

	private static void dfs(int r, int c, char[][] arr, boolean[][] visited) {
		visited[r][c] = true;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (!visited[nr][nc] && arr[r][c] == arr[nr][nc]) { // 새로 탐색하는 구역이 아직 방문하지 않았고 현재의 색과 같다면
				dfs(nr, nc, arr, visited);
			}
		}

	} // end of dfs

} // end of class
