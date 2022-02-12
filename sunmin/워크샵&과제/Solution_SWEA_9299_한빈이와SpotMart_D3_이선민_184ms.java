import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_SWEA_9299_한빈이와SpotMart_D3_이선민_184ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수

		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 과자 봉지의 개수(2 ≤ N ≤ 1000)
			int M = Integer.parseInt(st.nextToken()); // 무게 합 제한(2 ≤ M ≤ 2000000)
			int max = -1;

			st = new StringTokenizer(br.readLine(), " ");
			Integer[] arr = new Integer[N]; // 과자 무게 정보 저장
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr, Collections.reverseOrder()); // 크기 순 정렬

			int sum;
			outer: for (int k = 0; k < N - 1; k++) {
				if (arr[k] >= M) { // 과자 봉지 하나의 무게가 무게제한을 넘어가면 pass
					continue;
				}
				for (int l = k + 1; l < N; l++) {
					sum = arr[k] + arr[l];

					if (sum == M) {
						max = sum;
						break outer;
					} else if (sum < M && max < sum) {	// 무게 제한을 넘어가지 않는 선에서 최대 무게 찾기
						max = sum;
					}
				}
			} // end of outer

			sb.append("#").append(i).append(" ").append(max).append("\n");
		} // end of testcase

		System.out.print(sb);
	} // end of main

} // end of class
