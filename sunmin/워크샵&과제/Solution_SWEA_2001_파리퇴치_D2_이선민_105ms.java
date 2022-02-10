import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution_SWEA_2001_파리퇴치_D2_이선민_105ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {

			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]); // 배열크기
			int M = Integer.parseInt(s[1]); // 파리채크기

			int[][] arr = new int[N][N];
			// 배열에 파리 갯수 입력
			for (int i = 0; i < N; i++) {
				s = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(s[j]);
				}
			}

			int max = Integer.MIN_VALUE;
			int temp;
			// (0,0)~(N-M, N-M) 까지 탐색
			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {

					temp = 0;
					// 파리채 크기(M x M)만큼 탐색하며 죽은 파리 개수 구하기
					for (int r = i; r < i + M; r++) {
						for (int c = j; c < j + M; c++) {
							temp += arr[r][c];
						}
					}

					// 최대로 죽은 파리 개수 갱신
					if (temp > max) {
						max = temp;
					}
				}
			}

			sb.append("#").append(test_case).append(" ").append(max).append("\n");

		} // end of test_case
		System.out.print(sb);
	} // end of main
} // end of class
