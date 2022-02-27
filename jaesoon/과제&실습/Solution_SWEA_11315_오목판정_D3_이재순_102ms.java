import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_11315_오목판정_D3_이재순_102ms {
	static int count, N;
	static int[][] deltas = { { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
	static int[][] deltas2 = { { 0, -1 }, { -1, 1 }, { -1, 0 }, { -1, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
loop:	for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			char[][] pan = new char[N][];
			for (int i = 0; i < N; i++) pan[i] = br.readLine().toCharArray();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < 4; k++) {
						if (pan[i][j] == 'o') {
							int result = check(pan, i, j, k);
							if (result >= 4) {
								sb.append("#").append(tc).append(" ").append("YES\n");
								continue loop;
							}
						}
					}
				}
			}
			sb.append("#").append(tc).append(" ").append("NO\n");
		}
		System.out.print(sb);
	}// end of main

	public static int check(char[][] pan, int i, int j, int k) {
		int ni = i + deltas[k][0];
		int nj = j + deltas[k][1];
		if (ni > -1 && ni < N && nj > -1 && nj < N && pan[i][j] == pan[ni][nj]) {
			return 1 + check(pan, ni, nj, k);
		}
		return 0;
	}
}
