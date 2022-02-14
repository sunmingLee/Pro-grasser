import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3499_퍼펙트셔플_D3_이선민_122ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 수
		String[] arr;
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine()); // 카드의 수(1 ≤ N ≤ 1,000)
			st = new StringTokenizer(br.readLine());
			sb.append("#").append(test_case).append(" ");
			arr = new String[N];
			for (int i = 0; i < N; i++) { // 카드 덱 저장
				arr[i] = st.nextToken();
			}
			
			if (N % 2 == 0) { // 카드 개수가 짝수인 경우
				for (int i = 0; i < N / 2; i++) {
					sb.append(arr[i]).append(" ");
					sb.append(arr[i + N / 2]).append(" ");
				}
			} else {	// 카드 개수가 홀수인 경우
				for (int i = 0; i < N / 2; i++) {
					sb.append(arr[i]).append(" ");
					sb.append(arr[i + N / 2 + 1]).append(" ");
				}
				sb.append(arr[N/2]).append(" ");	// 가운데 남은 카드 마지막에 넣어주기
			}
			sb.deleteCharAt(sb.length() - 1); // 마지막 공백 지워주기
			sb.append("\n");

		} // end of testcase

		System.out.print(sb);
	} // end of main

} // end of class
