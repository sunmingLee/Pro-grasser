import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solution_SWEA_1954_달팽이숫자_D2_이선민_136ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(
				new FileReader("C:\\Users\\SM-LEE\\git\\seoul17_hw_leesunmin\\0203\\src\\input.txt"));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		// N-1 만큼 오른쪽부터 시계방향으로 숫자를 채워넣음.
		// 그다음은 N-3, N-5,.., 0보다 클때까지
		// N이 홀수인 경우, 정가운데 값을 N*N 저장
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());

			int size = N - 1;
			int num = 1;
			int[][] arr = new int[N][N];
			int r = 0;
			int c = 0;

			while (size > 0) {
				for (int i = 0; i < size; i++) { // 우
					arr[r][c++] = num++;
				}
				for (int i = 0; i < size; i++) { // 하
					arr[r++][c] = num++;
				}
				for (int i = 0; i < size; i++) { // 좌
					arr[r][c--] = num++;
				}
				for (int i = 0; i < size; i++) { // 상
					arr[r--][c] = num++;
				}
				r++;
				c++;
				size -= 2;

			} // end of while

			if (N % 2 != 0) {
				arr[r][c] = num;
			}
			
			sb.append("#").append(testCase).append("\n");
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}

			/*
			 * while (size < arr.length / 2) { for (; c < arr.length - size; c++) { // →
			 * arr[r][c] = num++; } c--; r++; for (; r < arr.length - size; r++) { // ↓
			 * arr[r][c] = num++; } r--; c--; for (; c >= 0 + size; c--) { // ← arr[r][c] =
			 * num++; } c++; r--; for (; r > 0 + size; r--) { // ↑ arr[r][c] = num++; }
			 * 
			 * r++; c++; size++; } // end of while
			 * 
			 * 
			 * // N이 홀수일 경우, 정가운데 한칸의 값 if (N % 2 != 0) { arr[N / 2][N / 2] = num; }
			 

			System.out.println("#" + testCase);
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}*/

		} // end of testCase
		System.out.print(sb);
	} // end of main
} // end of class
