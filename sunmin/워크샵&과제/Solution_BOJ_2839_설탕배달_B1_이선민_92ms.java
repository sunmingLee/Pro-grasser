import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_BOJ_2839_설탕배달_B1_이선민_92ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 배달해야하는 설탕 무게

		int sum = 0;
		for (int i = N / 5; i >= 0; i--) { // 5kg 설탕을 최대개수로
			sum = i * 5;
			if (sum == N) {
				System.out.println(i);
				System.exit(0);
			}
			for (int j = 1; sum < N; j++) {
				sum += 3;
				if (sum == N) {
					System.out.println(i + j);
					System.exit(0);
				}
			}
		}

		System.out.println(-1);
	} // end of main

}
