package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BOJ_2309_일곱난쟁이_B2_이선민_76ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		int[] person = new int[9]; // 난쟁이들의 키
		for (int i = 0; i < 9; i++) {
			person[i] = Integer.parseInt(br.readLine());
			sum += person[i];
		}

		int lier1 = -1, lier2 = -1; // 거짓말을 한 난쟁이
		loop: for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - (person[i] + person[j]) == 100) { // 두명의 키를 뺀 값이 100이면
					lier1 = i;
					lier2 = j;
					break loop;
				}
			}
		}

		int index = 0;
		int[] answer = new int[7]; // 정답인 일곱 난쟁이
		for (int i = 0; i < 9; i++) {
			if (i == lier1 || i == lier2) {
				continue;
			}
			answer[index++] = person[i];
		}
		Arrays.sort(answer);
		StringBuilder sb = new StringBuilder();
		for (int i : answer) {
			sb.append(i).append("\n");
		}
		System.out.print(sb.toString());

	} // end of main

} // end of class
