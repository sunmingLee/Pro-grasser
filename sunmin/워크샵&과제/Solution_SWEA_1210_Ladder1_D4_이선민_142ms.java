import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1210_Ladder1_D4_이선민_142ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(60); // 출력해야할 내용을 안다면 크기를 대강 정해주는것이 좋음
		StringTokenizer st;
		int[][] arr = new int[100][102]; // 배열의 좌우에 한겹을 감싸줌
		for (int test_case = 1; test_case <= 10; test_case++) {
			br.readLine(); // 첫번째 줄에 테스트 케이스 번호가 주어지지만 필요없음
			// 사다리 저장
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int c = -1; // 현재 열(맨 처음 시작은 2가 있는 열로)
			for (int i = 1; i <= 100; i++) {
				if (arr[99][i] == 2) {
					c = i;
					break;
				}
			}

			int r = 98; // 현재 행(맨 처음 시작은 2가 있는 행 바로 위쪽행으로)
			int way = 2; // 이동하고 있는 방향(왼쪽: -1, 오른쪽: +1)
			while (r > 0) { // 맨 위의 행에 도착할때까지
				if (arr[r][c + 1] == 1) { // 오른쪽으로 이어진 사다리가 있다면
					way = 1;
				} else if (arr[r][c - 1] == 1) { // 왼쪽으로 이어진 사다리가 있다면
					way = -1;
				}

				if (Math.abs(way) == 1) {
					while (arr[r][c] == 1) { // 사다리가 끊길때까지 이동
						c += way;
					}
					c -= way; // 사다리가 끊기기 전 열로 돌아옴
				}
				r--;
			} // end of while

			sb.append("#").append(test_case).append(" ").append(c - 1).append("\n");
		} // end of testcase

		System.out.print(sb);
	} // end of main

} // end of class
