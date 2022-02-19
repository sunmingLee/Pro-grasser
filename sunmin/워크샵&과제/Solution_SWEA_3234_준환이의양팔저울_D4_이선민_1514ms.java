import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3234_준환이의양팔저울_D4_이선민_1514ms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

		int[] weight;
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine()); // 무게추의 개수
			sb.append("#").append(test_case).append(" ");

			st = new StringTokenizer(br.readLine(), " ");
			if (N == 1) {
				sb.append(1).append("\n");
				continue;
			} else if (N == 2) {
				sb.append(2).append("\n");
				continue;
			}

			weight = new int[N]; // 주어진 무게추
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}

//			int ans = permutation(0, 0, 0, weight, 0);	// 비트마스킹 사용(그런데 왜 200ms정도 더나오지..?)
			boolean[] isSelected = new boolean[N];
			int ans = permutation(0, 0, 0, weight, isSelected);
			sb.append(ans).append("\n");

		} // end of testcase
		System.out.print(sb);
	} // end of main

	private static int permutation(int cnt, int left, int right, int[] weight, boolean[] isSelected) {

		if (cnt == weight.length) { // 경우의 수 하나 완료
			return 1;
		}

		int ans = 0;
		for (int i = 0; i < weight.length; i++) {
			if (isSelected[i]) {
				continue;
			}
			isSelected[i] = true;
			// 왼쪽에 다음 무게추 추가
			ans+= permutation(cnt + 1, left + weight[i], right, weight, isSelected);
			
			// 가능하다면 오른쪽에 다음 무게추 추가
			if(left>=right+weight[i]) {
				ans+=permutation(cnt + 1, left, right + weight[i], weight, isSelected);
			}
			isSelected[i] = false;

		}
		
		return ans;

	} // end of permutation

	private static int permutation(int cnt, int left, int right, int[] weight, int flag) {
		if (cnt == weight.length) { // 경우의 수 하나 완료
			return 1;
		}

		int ans = 0;
		for (int i = 0; i < weight.length; i++) {
			if ((flag & 1 << i) != 0) {
				continue;
			}
			// 왼쪽에 다음 무게추 추가
			ans += permutation(cnt + 1, left + weight[i], right, weight, flag | 1 << i);

			// 가능하다면 오른쪽에 다음 무게추 추가
			if (left >= right + weight[i]) {
				ans += permutation(cnt + 1, left, right + weight[i], weight, flag | 1 << i);
			}
		}
		
		return ans;

	} // end of permutation

} // end of class
