package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 무게가 양의 정수인 N개의 저울추가 주어질 때, 이 추들을 사용하여 측정할 수 없는 양의 정수 무게 중 최솟값을 구하는 프로그램을
 * 작성하시오.
 * 
 * 예를 들어, 무게가 각각 3, 1, 6, 2, 7, 30, 1인 7개의 저울추가 주어졌을 때, 이 추들로 측정할 수 없는 양의 정수 무게
 * 중 최솟값은 21이다.
 *
 */
public class Main_BOJ_2437_저울_G3_이선민_88ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 저울추의 개수(1<=N<=1000)
		int[] weight = new int[N]; // 주어진 무게추들
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(weight); // 오름차순으로 무게추 정렬

		long sum = 1; // 가장 적은 무게추가 1보다 클 경우 1을 만들수 없음
		for (int i = 0; i < weight.length; i++) {
			if (sum < weight[i]) { // 현재까지 합한 무게추가 다음 무게추의 무게를 만들수 없다면
				break;
			}
			sum += weight[i];
		}

		System.out.print(sum);

	} // end of main
} // end of class
