package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1592_영식이와친구들_B2_이선민_76ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[] person = new int[N]; // 각자 몇번 받은 횟수를 담을 배열
		person[1] = 1;
		int max = 1; // 지금까지 공을 받은 횟수가 최대인 사람의 공받은 횟수
		int temp = 1; // 현재 공을 가지고있는 사람
		int next; // 공을 받을 다음 사람
		int cnt = 0;
		while (max != M) {
			if (person[temp] % 2 == 0) { // 받은 횟수가 짝수
				next = (temp + N - L) % N;
			} else { // 받은 횟수가 홀수
				next = (temp + L) % N;
			}

			person[next]++;
			if (max < person[next]) {
				max = person[next];
			}
			temp = next;
			cnt++;
		}

		System.out.print(cnt);

	} // end of main

} // end of class
