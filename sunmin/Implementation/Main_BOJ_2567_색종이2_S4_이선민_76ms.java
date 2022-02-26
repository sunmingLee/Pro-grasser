package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2567_색종이2_S4_이선민_76ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 색종이의 수
		int[][] board = new int[101][101]; // 도화지
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			// 색종이 크기만큼 1로 칠해주기
			for (int k = x; k < x + 10; k++) {
				for (int j = y; j < y + 10; j++) {
					board[k][j] = 1;
				}
			}
		}
		
		int length = 0; // 둘레 길이
		int[] dr = { 0, 1, 0, -1 }; // 4방탐색(우, 하, 좌, 상)
		int[] dc = { 1, 0, -1, 0 };

		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if (board[i][j] == 1) { // 해당칸에 색종이가 붙어있다면
					for (int k = 0; k < 4; k++) { // 4방탐색
						int nr = i + dr[k];
						int nc = j + dc[k];
						if (board[nr][nc] == 0) {
							length++;
						}
					} // 4방탐색 종료
				}
			}
		}
		System.out.print(length);
	} // end of main

} // end of class
