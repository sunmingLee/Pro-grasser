package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1600_말이되고픈원숭이_G4_이선민_516ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		char[][] map = new char[row][];
		for (int i = 0; i < row; i++) {
			map[i] = br.readLine().replace(" ", "").toCharArray();
		}

		// int[] 배열 0: x좌표, 1: y좌표, 2: 해당 칸까지 오는데 움직인 횟수, 3: k 사용 횟수
		Queue<int[]> q = new ArrayDeque<int[]>();
		boolean[][][] visited = new boolean[row][col][k + 1];
		q.offer(new int[] { 0, 0, 0, 0 });
		visited[0][0][0] = true;
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		int[] horsedr = { 1, 2, 2, 1, -1, -2, -2, -1 };
		int[] horsedc = { 2, 1, -1, -2, -2, -1, 1, 2 };
		while (!q.isEmpty()) {
			int[] current = q.poll();
			if (current[0] == row - 1 && current[1] == col - 1) {
				System.out.println(current[2]);
				return;
			}
			for (int i = 0; i < 4; i++) { // 원숭이처럼 이동
				int nr = current[0] + dr[i];
				int nc = current[1] + dc[i];
				if (nr < 0 || nr >= row || nc < 0 || nc >= col || visited[nr][nc][current[3]] || map[nr][nc] == '1') {
					continue;
				}

				visited[nr][nc][current[3]] = true;
				q.offer(new int[] { nr, nc, current[2] + 1, current[3] });
			}

			if (current[3] < k) { // 아직 말 이동 횟수가 남아있다면
				for (int i = 0; i < 8; i++) { // 말처럼 이동
					int nr = current[0] + horsedr[i];
					int nc = current[1] + horsedc[i];
					int nk = current[3] + 1;
					if (nr < 0 || nr >= row || nc < 0 || nc >= col || visited[nr][nc][nk] || map[nr][nc] == '1') {
						continue;
					}

					visited[nr][nc][nk] = true;
					q.offer(new int[] { nr, nc, current[2] + 1, nk});
				}
			}
		}

		System.out.println(-1);
	} // end of main

} // end of class
