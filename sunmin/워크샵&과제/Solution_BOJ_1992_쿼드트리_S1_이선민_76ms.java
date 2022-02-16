import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BOJ_1992_쿼드트리_S1_이선민_76ms {

	private static int[][] arr;
	private static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); // 배열의 한 변 크기

		String s;
		arr = new int[N][N]; // 입력받은 배열
		for (int i = 0; i < N; i++) {
			s = br.readLine(); // 배열의 한줄을 읽어옴
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		smaller(N, 0, 0);
		sb.append("\n");
		System.out.print(sb);
	} // end of main

	/**
	 * 4분할하여 왼쪽 위부터 z모양으로 압축가능한지 확인
	 */
	private static void smaller(int size, int x, int y) {
		// 압축이 가능하다면 해당 영역의 숫자를 출력문에 담음
		if (check(size, x, y)) {
			sb.append(arr[x][y]);
			return;
		}

		// 압축이 불가능하다면 4분할해서 다시 탐색
		int halfSize = size / 2;

		sb.append("(");

		smaller(halfSize, x, y); // 왼쪽위
		smaller(halfSize, x, y + halfSize); // 오른쪽위
		smaller(halfSize, x + halfSize, y); // 왼쪽아래
		smaller(halfSize, x + halfSize, y + halfSize); // 오른쪽아래

		sb.append(")");

	} // end of smaller

	/**
	 * 해당범위의 숫자가 모두 같은지 확인(같으면 true, 다르면 false 반환)
	 */
	private static boolean check(int size, int x, int y) {
		int bit = arr[x][y];
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (arr[i][j] != bit) { // 범위내에 다른 숫자가 하나라도 있다면
					return false;
				}
			}
		}

		return true;

	} // end of check

} // end of class
