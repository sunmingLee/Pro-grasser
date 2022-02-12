import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_5215_햄버거다이어트_D3_이선민_170ms {
	static int N, L, maxPoint;
	static int[] points;
	static int[] calories;

	public static void main(String[] args) throws NumberFormatException, IOException {
		//BufferedReader br = new BufferedReader(new FileReader("C:\\SSAFY\\01_java\\0207\\src\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		
		for (int testCase = 1; testCase <= T; testCase++) {
			String[] s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]); // 재료의 수(1 ≤ N ≤ 20)
			L = Integer.parseInt(s[1]); // 제한 칼로리(1 ≤ L ≤ 10^4)

			points = new int[N]; // 재료 맛점수 정보
			calories = new int[N]; // 재료 칼로리 정보
			for (int i = 0; i < N; i++) {
				s = br.readLine().split(" ");
				points[i] = Integer.parseInt(s[0]);
				calories[i] = Integer.parseInt(s[1]);
			}

			maxPoint = 0;
			comb(0, 0, 0);

			sb.append("#").append(testCase).append(" ").append(maxPoint).append("\n");

		} // end of testCase
		System.out.print(sb);
	} // end of main

	// 모든 부분집합을 확인하며 제한 칼로리를 넘기지 않는 조합 중 맛점수가 가장 높은 결과를 저장한다.
	public static void comb(int cnt, int cal, int point) {
		// 칼로리 초과
		if (cal > L) {
			return;
		}

		// N번째 원소까지 선택 완료
		if (cnt == N) {
			maxPoint = Math.max(maxPoint, point);
			return;
		}
		
		// 재료 하나를 기준으로 이 재료를 뽑거나, 안뽑거나 둘 중 하나의 선택을 할 수 있다.
		// 이 재료를 선택했다면 해당 재료의 맛점수와 칼로리를 더해주고 다음 인덱스로.
		comb(cnt + 1, cal + calories[cnt], point + points[cnt]);
		// 이 재료를 선택하지 않았다면 다음 인덱스로.
		comb(cnt + 1, cal, point);
	} // end of comb
} // end of class
