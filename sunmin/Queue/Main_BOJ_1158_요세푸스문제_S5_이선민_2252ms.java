package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다. 한
 * 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서
 * 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1,
 * 4>이다.
 * 
 * N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.
 * 
 */
public class Main_BOJ_1158_요세푸스문제_S5_이선민_2252ms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // (1 ≤ K ≤ N ≤ 5,000)
		int K = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder(N * 3);

		int[] num = new int[N];
		for (int i = 1; i <= N; i++) {
			num[i - 1] = i;
		}

		sb.append("<");
		int index = K - 1; // 제거할 인덱스
		int cnt;

		for (int i = 0; i < N; i++) {
			sb.append(num[index]).append(", ");
			num[index] = 0;

			if (i == N - 1) {	// 마지막 원소까지 빼내고나면 while문안에서 무한루프를 돌기때문에 for문을 빠져나옴
				break;
			}
			cnt = 0; // 확인할 인덱스 갯수
			while (cnt < K) {
				index = (index + 1) % N;
				if (num[index] == 0) { // 확인한 인덱스가 이미 제거된 대상이라면 cnt로 치지 않음
					continue;
				}
				cnt++;
			}
		}
		sb.delete(sb.length() - 2, sb.length()); // 맨뒤의 ,공백 제거
		sb.append(">\n");

		System.out.print(sb);
	} // end of main

} // end of class
