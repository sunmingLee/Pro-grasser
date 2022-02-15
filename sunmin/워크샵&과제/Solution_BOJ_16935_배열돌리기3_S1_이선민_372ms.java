import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_BOJ_16935_배열돌리기3_S1_이선민_372ms {

	static int N, M, temp, halfN, halfM;
	static int[][] arr, answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 배열의 세로 크기
		M = Integer.parseInt(st.nextToken()); // 배열의 가로 크기
		
		int R = Integer.parseInt(st.nextToken()); // 수행해야하는 회전수
		arr = new int[N][M]; // 주어진 배열 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] opNum = new int[R]; // 실행할 연산번호 저장
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			opNum[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0; // 현재까지 실행한 연산 횟수
		while (cnt + 1 < R) {
			// 상하반전이나 좌우반전 연산이 연이어있으면 원상태로 돌아옴
			if ((opNum[cnt] == 1 && opNum[cnt + 1] == 1) || (opNum[cnt] == 2 && opNum[cnt + 1] == 2)) {
				cnt += 2;
				continue;
			}

			// 연산 번호 3,4가 연이어있으면 원상태로 돌아옴
			if ((opNum[cnt] == 3 && opNum[cnt + 1] == 4) || (opNum[cnt] == 4 && opNum[cnt + 1] == 3)) {
				cnt += 2;
				continue;
			}

			// 연산 번호 5,6이 연이어있으면 원상태로 돌아옴
			if ((opNum[cnt] == 5 && opNum[cnt + 1] == 6) || (opNum[cnt] == 6 && opNum[cnt + 1] == 5)) {
				cnt += 2;
				continue;
			}

			operation(opNum[cnt]);
			cnt++;

		} // end of while

		// 마지막 연산 실행
		if (cnt == R - 1) {
			operation(opNum[cnt]);
		}

		// 정답배열 출력
		for (int[] is : answer) {
			for (int a : is) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb);
	} // end of main

	public static void operation(int opNum) {
		switch (opNum) {
		case 1: // 상하반전
			answer = new int[N][M]; // 연산 결과 배열
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					answer[N - 1 - i][j] = arr[i][j];
				}
			}
			break;
		case 2: // 좌우반전
			answer = new int[N][M]; // 연산 결과 배열
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					answer[i][M - 1 - j] = arr[i][j];
				}
			}
			break;
		case 3: // 오른쪽으로 90도 회전
			answer = new int[M][N];

			// 0행부터 한 행씩 answer의 맨 끝 열로 세움
			// 1 2 3 -> 1
//						2
//						3
			int c = N - 1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					answer[j][c] = arr[i][j];
				}
				c--;
			}

			// 크기 변환
			temp = N;
			N = M;
			M = temp;

			break;
		case 4: // 왼쪽으로 90도 회전
			answer = new int[M][N];

			// 0행부터 한 행씩 역순으로 answer의 맨 처음 열로 세움
			// 1 2 3 -> 3
//						2
//						1
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					answer[M - 1 - j][i] = arr[i][j];
				}
			}

			// 크기 변환
			temp = N;
			N = M;
			M = temp;

			break;
		case 5: // 부분배열을 시계방향 회전
			answer = new int[N][M]; // 연산 결과 배열
			halfN = N / 2; // 행의 중앙값
			halfM = M / 2; // 열의 중앙값
			
			// 1 -> 2
			for (int i = 0; i < halfN; i++) {
				for (int j = 0; j < halfM; j++) {
					answer[i][j + halfM] = arr[i][j];
				}
			}

			// 2 -> 3
			for (int i = 0; i < halfN; i++) {
				for (int j = halfM; j < M; j++) {
					answer[i + halfN][j] = arr[i][j];
				}
			}

			// 3 -> 4
			for (int i = halfN; i < N; i++) {
				for (int j = halfM; j < M; j++) {
					answer[i][j - halfM] = arr[i][j];
				}
			}

			// 4 -> 1
			for (int i = N - 1; i >= halfN; i--) {
				for (int j = 0; j < halfM; j++) {
					answer[i - halfN][j] = arr[i][j];
				}
			}

			break;
		case 6: // 부분배열을 반시계방향 회전
			answer = new int[N][M]; // 연산 결과 배열
			halfN = N / 2; // 행의 중앙값
			halfM = M / 2; // 열의 중앙값
			
			// 1 -> 4
			for (int i = 0; i < halfN; i++) {
				for (int j = 0; j < halfM; j++) {
					answer[i + halfN][j] = arr[i][j];
				}
			}

			// 4 -> 3
			for (int i = halfN; i < N; i++) {
				for (int j = 0; j < halfM; j++) {
					answer[i][j + halfM] = arr[i][j];
				}
			}

			// 3 -> 2
			for (int i = N - 1; i >= halfN; i--) {
				for (int j = halfM; j < M; j++) {
					answer[i - halfN][j] = arr[i][j];
				}
			}

			// 2 -> 1
			for (int i = 0; i < halfN; i++) {
				for (int j = halfM; j < M; j++) {
					answer[i][j - halfM] = arr[i][j];
				}
			}
			break;
		} // end of switch

		arr = answer;
	} // end of operation

} // end of class
