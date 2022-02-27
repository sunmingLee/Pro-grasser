import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_BOJ_7576_토마토_G5_이선민_584ms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int[][] map = new int[row][col];
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		for (int i = 0; i < row; i++) {
//			for (int j = 0; j < col; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}

		Queue<int[]> queue = new ArrayDeque<int[]>();
		int cnt = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (map[i][j] != 0) {
					cnt++;

					if (map[i][j] == 1) {
						queue.offer(new int[] { i, j });
					}
				}
			}
		}
		if (cnt == row * col) {
			System.out.print(0);
			return;
		}

		cnt = 0;
		int[] dr = { -1, 0, 1, 0 }; // 위부터 시계방향
		int[] dc = { 0, 1, 0, -1 };
		while (!queue.isEmpty()) {
			int size = queue.size();
			cnt++;

			while (size-- > 0) {
				int[] current = queue.poll();
				for (int i = 0; i < 4; i++) {
					int nr = current[0] + dr[i];
					int nc = current[1] + dc[i];

					try {
						if (map[nr][nc] == 0) {
							map[nr][nc] = 1;
							queue.offer(new int[] { nr, nc });
						}

					} catch (ArrayIndexOutOfBoundsException e) {
					}
				}
			}

		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (map[i][j] == 0) {
					System.out.print(-1);
					return;
				}
			}
		}

		System.out.print(cnt - 1);

	} // end of main

} // end of class
