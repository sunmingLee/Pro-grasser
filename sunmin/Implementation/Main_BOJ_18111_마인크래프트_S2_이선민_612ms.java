package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * lvalue는 세로 N, 가로 M 크기의 집터를 골랐다. 집터 맨 왼쪽 위의 좌표는 (0, 0)이다. 우리의 목적은 이 집터 내의 땅의
 * 높이를 일정하게 바꾸는 것이다. 우리는 다음과 같은 두 종류의 작업을 할 수 있다.
 * 
 * 1. 좌표 (i, j)의 가장 위에 있는 블록을 제거하여 인벤토리에 넣는다. 2. 인벤토리에서 블록 하나를 꺼내어 좌표 (i, j)의 가장
 * 위에 있는 블록 위에 놓는다.
 * 
 * 1번 작업은 2초가 걸리며, 2번 작업은 1초가 걸린다. 밤에는 무서운 몬스터들이 나오기 때문에 최대한 빨리 땅 고르기 작업을 마쳐야
 * 한다. ‘땅 고르기’ 작업에 걸리는 최소 시간과 그 경우 땅의 높이를 출력하시오.
 *
 */
public class Main_BOJ_18111_마인크래프트_S2_이선민_612ms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 집터의 세로길이 (1 ≤ M, N ≤ 500)
		int M = Integer.parseInt(st.nextToken()); // 집터의 가로길이 (0 ≤ B ≤ 6.4 × 10^7)
		int B = Integer.parseInt(st.nextToken()); // 인벤토리 속 블럭의 개수

		// 집터의 높이 정보 저장 (땅의 높이는 0 이상 256 이하)
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0; // 평탄화 시 가장 높게 만들 수 있는 땅의 높이
		int min = 256; // 집터 중 가장 낮은 땅의 높이
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				max += arr[i][j];
				min = min > arr[i][j] ? arr[i][j] : min;
			}
		}
		max = (max + B) / (N * M); // 인벤토리 속 블럭의 개수까지 합한 뒤, 집터의 넓이로 나눠줌

		int cnt = Integer.MAX_VALUE; // 땅을 고르는데 걸리는 시간
		int highest = 0;	// 같은 시간일 때 높이가 더 높은 경우를 출력
		while (max >= min) {
			int tempCnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// 현재 블럭이 최대로 만들수 있는 땅의 높이보다 높다면 블럭을 제거함
					if (arr[i][j] > max) {
						tempCnt += (arr[i][j] - max) * 2;
					} else { // 현재 블럭이 만들 수 있는 땅의 높이보다 낮다면 블럭을 쌓아줌
						tempCnt += max - arr[i][j];
					}
				}
			}

			// 최소 시간 갱신
			if (tempCnt < cnt) {
				cnt = tempCnt;
				highest = max;
			}

			// 최대 높이를 낮춰서 다시 반복
			max--;
		}
		sb.append(cnt).append(" ").append(highest);
		System.out.print(sb);
	} // end of main

} // end of class
