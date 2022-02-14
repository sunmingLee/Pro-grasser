import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BOJ_2961_도영이가만든맛있는음식_S1_이선민_80ms {
	static int min, N;
	static int[] sour, bitter;
	static boolean[] isSelected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 재료의 개수
		sour = new int[N]; // 재료의 신맛
		bitter = new int[N]; // 재료의 쓴맛
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}

		min = Integer.MAX_VALUE; // 맛의 최소차이
		isSelected = new boolean[N];
		subset(0);
		System.out.println(min);
	} // end of main

	private static void subset(int cnt) {
		if (cnt == N) {
			int tempS = 1, tempB = 0, cntM = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					cntM++;
					tempS *= sour[i];
					tempB += bitter[i];
				}
			}
			
			if(cntM ==0) {	// 재료가 하나도 안들어갔으면 안됨
				return;
			}
			min = Math.min(min, Math.abs(tempS - tempB));
			return;
		}

		isSelected[cnt] = true;
		subset(cnt + 1);
		isSelected[cnt] = false;
		subset(cnt + 1);

	}

} // end of class
