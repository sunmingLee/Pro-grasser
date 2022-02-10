import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_2805_농작물수확하기_D3_이선민_136ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(
				new FileReader("C:\\Users\\SM-LEE\\git\\seoul17_hw_leesunmin\\0204\\src\\input (3).txt"));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine()); // 1 ≤ N ≤ 49
			int sum = 0;

			/*
			 * for (int i = 0; i < N; i++) { String s = br.readLine(); int x = Math.abs(2 /
			 * N - i); // i행에서 합산을 시작할 열의 좌표 for (int j = x; j < N-x; j++) { // i행의 마름모 영역
			 * sum += s.charAt(j) - '0'; } }
			 */

			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					if (i + j >= N / 2 && i + j <= N / 2 * 3 && i - j >= -N / 2 && i - j <= N / 2) { // 마름모 영역 내부라면
						sum += s.charAt(j) - '0';
					}
				}
			}

			/*
			 * int[][] arr = new int[N][N]; for (int i = 0; i < arr.length; i++) { char[] c
			 * = br.readLine().toCharArray(); for (int j = 0; j < arr.length; j++) {
			 * arr[i][j] = c[j] - '0'; } }
			 * 
			 * int sum = 0; int index = N / 2; // 위쪽 절반 for (int i = 0; i <= arr.length / 2;
			 * i++) { int temp = index; for (int j = 0; j < 2 * i + 1; j++) { sum +=
			 * arr[i][temp++]; } index--; }
			 * 
			 * // 아래쪽 절반 index = 1; for (int i = arr.length / 2 + 1; i < arr.length; i++) {
			 * int temp = index; for (int j = 0; j < -2 * i + 9; j++) { sum +=
			 * arr[i][temp++]; } index++; }
			 */

			sb.append("#").append(test_case).append(" ").append(sum).append("\n");

		} // end of test_case
		System.out.print(sb);
	} // end of main
} // end of class
