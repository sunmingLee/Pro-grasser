import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_BOJ_3040_백설공주와일곱난쟁이_B2_이선민_76ms {
	static int[] dwarf, temp;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		dwarf = new int[9];
		for (int i = 0; i < 9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}

		temp = new int[7]; // 조합의 결과를 저장할 배열
		comb(0, 0);
	} // end of main

	private static void comb(int cnt, int start) {
		if (cnt == 7) {
			int sum = 0;
			for (int i : temp) {
				sum += i;
				sb.append(i).append("\n");
			}

			if (sum != 100) {
				sb.setLength(0);
			}
			System.out.print(sb);
			return;
		}

		for (int i = start; i < 9; i++) {
			temp[cnt] = dwarf[i];
			comb(cnt + 1, i + 1);
		}

	}	// end of comb

} // end of class
