package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 독일 로또는 {1, 2, ..., 49}에서 수 6개를 고른다.
 * 
 * 로또 번호를 선택하는데 사용되는 가장 유명한 전략은 49가지 수 중 k(k>6)개의 수를 골라 집합 S를 만든 다음 그 수만 가지고 번호를
 * 선택하는 것이다.
 * 
 * 예를 들어, k=8, S={1,2,3,5,8,13,21,34}인 경우 이 집합 S에서 수를 고를 수 있는 경우의 수는 총 28가지이다.
 * ([1,2,3,5,8,13], [1,2,3,5,8,21], [1,2,3,5,8,34], [1,2,3,5,13,21], ...,
 * [3,5,8,13,21,34])
 * 
 * 집합 S와 k가 주어졌을 때, 수를 고르는 모든 방법을 구하는 프로그램을 작성하시오.
 *
 */
public class Main_BOJ_6603_로또_S2_이선민_88ms {

	private static int k;
	private static int[] S, lotto;
	private static StringBuilder sb = new StringBuilder();;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s;
		while ((s = br.readLine()).length() > 1) { // 0을 입력받기 전까지
			st = new StringTokenizer(s, " ");
			k = Integer.parseInt(st.nextToken()); // k(6 < k < 13)

			S = new int[k]; // k개의 수를 담은 집합S
			for (int i = 0; i < k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}

			lotto = new int[6]; // 뽑을 6개의 숫자를 담은 배열
			comb(0, 0);

			sb.append("\n");
		} // end of while

		System.out.print(sb);

	} // end of main

	private static void comb(int cnt, int start) {
		if (cnt == 6) {
			for (int num : lotto) {
				sb.append(num + " ");
			}

			sb.append("\n");
			return;
		}

		// 앞쪽부터 조합 생성
		for (int i = start; i < k; i++) {
			lotto[cnt] = S[i];
			comb(cnt + 1, i + 1);
		}

	} // end of comb

} // end of class
