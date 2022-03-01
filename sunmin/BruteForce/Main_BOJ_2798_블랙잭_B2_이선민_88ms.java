package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2798_블랙잭_B2_이선민_88ms {
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] cards = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		comb(0, 0, 0, cards, M); // 조합 실행
		System.out.print(ans);
	} // end of main

	private static void comb(int cnt, int start, int sum, int[] cards, int M) {
		if (cnt == 3) {
			if (sum == M) {
				System.out.print(M);
				System.exit(0);
			}

			ans = ans < sum ? sum : ans;
			return;
		}

		for (int i = start; i < cards.length; i++) {
			if (sum + cards[i] <= M) {
				comb(cnt + 1, i + 1, sum + cards[i], cards, M);
			}
		}
	} // end of comb

} // end of class
