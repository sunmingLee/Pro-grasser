import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_BOJ_16926_배열돌리기1_S2_이선민_976ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 배열의 세로 크기
		int M = Integer.parseInt(st.nextToken()); // 배열의 가로 크기
		int R = Integer.parseInt(st.nextToken()); // 수행해야하는 회전수
		int[][] arr = new int[N][M]; // 주어진 배열 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		//int realR = R % ((N - 1 + M - 1) * 2); // 실제로 위치가 변하는 회전수
		int r, c, inner;
		int[][] answer = new int[N][M]; // 정답 배열
		for (int i = 0; i < answer.length; i++) {
			answer[i] = Arrays.copyOf(arr[i], arr[i].length);
		}

		for (int i = 0; i < R; i++) {
			r = 0;
			c = 0;
			inner = 0;
			while (N - inner > 0 && M - inner > 0) {
				for (; r + 1 < N - inner / 2; r++) { // 하
					answer[r + 1][c] = arr[r][c];
				}

				for (; c + 1 < M - inner / 2; c++) { // 우
					answer[r][c + 1] = arr[r][c];
				}

				for (; r - 1 >= 0 + inner / 2; r--) { // 상
					answer[r - 1][c] = arr[r][c];
				}

				for (; c - 1 >= 0 + inner / 2; c--) { // 좌
					answer[r][c - 1] = arr[r][c];
				}

				r++;
				c++;
				inner += 2;

			} // 한바퀴 회전 끝

			// 최종결과에서 회전을 반복해야하므로 arr 배열에 정답 배열값을 담아줌
			for (int j = 0; j < answer.length; j++) {
				arr[j] = Arrays.copyOf(answer[j], answer[j].length);
			}
		} // end of for(회전 완료)

		for (int[] is : answer) { // 정답배열 출력
			for (int a : is) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb);
	} // end of main

} // end of class
