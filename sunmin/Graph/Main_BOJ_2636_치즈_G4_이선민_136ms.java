package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2636_치즈_G4_이선민_136ms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		char[][] map = new char[row][];
		int cheese = 0;
		for (int i = 0; i < row; i++) {
			map[i] = br.readLine().replace(" ", "").toCharArray();
			for (int j = 0; j < col; j++) {
				if (map[i][j] == '1') {
					cheese++;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		int time = 0;
		while (cheese > 0) {
			time++;
			int melt = melting(row, col, map);
			if (cheese - melt == 0) {
				sb.append(time).append("\n");
				sb.append(cheese).append("\n");
				break;
			}

			cheese -= melt;
		}

		System.out.print(sb.toString());

	} // end of main

	/**
	 * 한 시간동안 녹은 치즈의 개수 반환
	 */
	private static int melting(int row, int col, char[][] map) {
		int cnt = 0;
		Queue<int[]> q = new ArrayDeque<int[]>();
		boolean[][] visited = new boolean[row][col];
		q.offer(new int[] { 0, 0 });
		visited[0][0] = true;
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		while (!q.isEmpty()) {
			int[] current = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = current[0] + dr[i];
				int nc = current[1] + dc[i];

				if (nr < 0 || nr >= row || nc < 0 || nc >= col || visited[nr][nc]) {
					continue;
				}

				if (map[nr][nc] == '0') {
					q.offer(new int[] { nr, nc });
				} else {
					map[nr][nc] = '0';
					cnt++;
				}

				visited[nr][nc] = true;
			}
		} // end of while
		return cnt;
	} // end of melting

} // end of class
