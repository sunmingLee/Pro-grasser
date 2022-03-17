package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2096_내려가기_G4_이선민_328ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 줄의 개수(1 ≤ N ≤ 100,000)
		int[] min = new int[3]; // 해당칸으로 왔을때 가질수 있는 최소값
		int[] max = new int[3]; // 해당칸으로 왔을때 가질수 있는 최대값
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (i == 0) { // 맨 윗줄
				min[0] = max[0] = a;
				min[1] = max[1] = b;
				min[2] = max[2] = c;
			} else {
				// 최소값 구하기
				int tempminA = min[0];
				int tempminB = min[1];
				int tempminC = min[2];
				min[0] = Math.min(min[0], min[1]) + a;
				min[1] = Math.min(Math.min(tempminA, tempminB), tempminC) + b;
				min[2] = Math.min(tempminB, tempminC) + c;

				// 최대값 구하기
				int tempmaxA = max[0];
				int tempmaxB = max[1];
				int tempmaxC = max[2];
				max[0] = Math.max(max[0], max[1]) + a;
				max[1] = Math.max(Math.max(tempmaxA, tempmaxB), tempmaxC) + b;
				max[2] = Math.max(tempmaxB, tempmaxC) + c;
			}
		}

		int maxAnswer = Integer.MIN_VALUE;
		for (int i = 0; i < 3; i++) {
			if (maxAnswer < max[i]) {
				maxAnswer = max[i];
			}
		}

		int minAnswer = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			if (minAnswer > min[i]) {
				minAnswer = min[i];
			}
		}
		System.out.print(maxAnswer + " " + minAnswer);
	} // end of main

} // end of class
