package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2615_오목_S2_이선민_96ms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = 19;
		char[][] board = new char[N][];
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().replace(" ", "").toCharArray();
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == '0') {
					continue;
				}

				for (int k = 0; k < 4; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];

					if (check(i, j, k, board)) {
						if (dfs(nr, nc, board[i][j], k, 1, board)) {
							sb.append(board[i][j]).append("\n");
							sb.append(i + 1).append(" ").append(j + 1);
							System.out.print(sb.toString());
							System.exit(0);
						}
					}
				}
			}
		}

		System.out.print(0);
	} // end of main

	static int[] dr = { -1, 0, 1, 1 }; // 오른쪽위, 오른쪽, 오른쪽아래, 아래
	static int[] dc = { 1, 1, 1, 0 };

	private static boolean dfs(int r, int c, char color, int way, int cnt, char[][] board) {
		boolean flag = false;
		try {
			if (cnt == 5) {
				if (r < 0 || r > 18 || c < 0 || c > 18) { // 바둑판의 가장자리에 붙어서 오목인 경우
					return true;
				} else if (board[r][c] == color) { // 6목일 경우
					return false;
				} else {
					return true;
				}
			}

			if (board[r][c] != color) {
				return false;
			}

			flag = dfs(r + dr[way], c + dc[way], color, way, cnt + 1, board);

		} catch (ArrayIndexOutOfBoundsException e) {
		}

		return flag;
	} // end of dfs

	private static boolean check(int r, int c, int way, char[][] board) {
		try {
			if (board[r][c] != board[r - dr[way]][c - dc[way]]) {
				return true;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return true;
		}

		return false;
	} // end of check

} // end of class
