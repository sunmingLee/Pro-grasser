import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_JUNGOL_1828_냉장고_이선민_99ms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 화학물질의 수(1<=N<=100)

		int[][] fridge = new int[N][2]; // 최고온도와 최저온도를 담을 냉장고

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			fridge[i][0] = Integer.parseInt(st.nextToken());	// 최저온도
			fridge[i][1] = Integer.parseInt(st.nextToken());	// 최고온도
		}
		
		// 최대온도로 오름차순 정렬
		Arrays.sort(fridge, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		int max = fridge[0][1];
		int cnt = 1;
		
		// 두번째 화학물질부터 검사
		for (int i = 1; i < N; i++) {
			if(max < fridge[i][0]) {
				max = fridge[i][1];
				cnt++;
			}
		}
		
		System.out.println(cnt);

	} // end of main

} // end of class
