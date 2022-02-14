import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_6808_규영이와인영이의카드게임_D3_이선민_2797ms {
	static int Gwin, Iwin;
	static int[] gue, in, temp;
	static boolean[] isSelected = new boolean[9];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수

		gue = new int[9]; // 규영이의 카드
		in = new int[9]; // 인영이의 카드
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			boolean[] gueCard = new boolean[9 * 2 + 1]; // 인영이의 카드를 찾기위해 규영이의 카드 숫자를 저장해둔 배열
			for (int i = 0; i < 9; i++) {
				gue[i] = Integer.parseInt(st.nextToken());
				gueCard[gue[i]] = true;
			}

			// 인영이의 카드 탐색 및 저장
			for (int i = 1, j = 0; i <= 9 * 2; i++) {
				if (!gueCard[i]) {
					in[j++] = i;
				}
			}

			Gwin = 0; // 규영이가 이긴 게임수
			Iwin = 0; // 인영이가 이긴 게임수
			temp = new int[9]; // 인영이의 카드로 만드는 순열
			permutation(0);

			sb.append("#").append(test_case).append(" ").append(Gwin).append(" ").append(Iwin).append("\n");
		} // end of testcase
		System.out.print(sb);
	} // end of main

	private static void permutation(int cnt) {
		if (cnt == 9) {
			int a = 0, b = 0;
			for (int i = 0; i < 9; i++) {
				if (gue[i] > temp[i]) { // 규영이의 카드가 더 큰경우
					a += gue[i] + temp[i];
				} else {
					b += gue[i] + temp[i];
				}
			}

			// 1~18까지의 합 / 2 = 85
			if (a > b) { // 규영이의 총합이 더 크다면
				Gwin++;
			} else if (a < b) { // 인영이의 총합이 더 크다면
				Iwin++;
			}

			return;
		}

		for (int i = 0; i < 9; i++) {
			if (isSelected[i] == true) {
				continue;
			}
			temp[cnt] = in[i];
			isSelected[i] = true;
			permutation(cnt + 1);
			isSelected[i] = false;
		}
	} // end of permutation

} // end of class
