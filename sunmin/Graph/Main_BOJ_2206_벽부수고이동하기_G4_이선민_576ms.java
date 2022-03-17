package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2206_벽부수고이동하기_G4_이선민_576ms {
	static class Position implements Comparable<Position> {
		int row, col;
		int count;
		boolean crush;

		public Position(int row, int col, int count, boolean crush) {
			super();
			this.row = row;
			this.col = col;
			this.count = count;
			this.crush = crush;
		}

		@Override
		public int compareTo(Position o) {
			return this.count - o.count;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		Queue<Position> q = new ArrayDeque<Position>();
		q.offer(new Position(0, 0, 1, false));
		int[] dr = { 0, 1, 0, -1 }; // 우 하 좌 상
		int[] dc = { 1, 0, -1, 0 };
		boolean[][][] visited = new boolean[N][M][2]; // 0: 벽을 안부수고 방문한 경우, 1: 벽을 부수고 방문한 경우
		visited[0][0][0] = true;
		while (!q.isEmpty()) {
			Position current = q.poll();
			if (current.row == N - 1 && current.col == M - 1) {
				System.out.print(current.count);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nr = current.row + dr[i];
				int nc = current.col + dc[i];

				try {
					if (map[nr][nc] == '1') { // 벽인 경우
						if (!current.crush) { // 벽을 부순적이 없어야함
							q.offer(new Position(nr, nc, current.count + 1, true));
						}
					} else { // 벽이 아닌 경우
						if (current.crush && !visited[nr][nc][1]) {
							visited[nr][nc][1] = true;
							q.offer(new Position(nr, nc, current.count + 1, current.crush));
						} else if (!current.crush && !visited[nr][nc][0]) {
							visited[nr][nc][0] = true;
							q.offer(new Position(nr, nc, current.count + 1, current.crush));
						}
					}
				} catch (ArrayIndexOutOfBoundsException e) {
				}
			}
		} // end of while
		System.out.print(-1);

	} // end of main

} // end of class
