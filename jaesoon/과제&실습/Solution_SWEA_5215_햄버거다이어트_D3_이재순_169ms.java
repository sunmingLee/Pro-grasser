import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_5215_햄버거다이어트_D3_이재순_169ms {
	static int maxScore;
	static int[][] arr;
	static int N, L;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int testcase = 0; testcase < T; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			arr = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			maxScore = 0;
			makeBurger(0,0,0);
			sb.append("#").append(testcase+1).append(" ").append(maxScore).append("\n");
		}
		System.out.println(sb);
	}//end of main
	private static void makeBurger(int idx, int score, int kcal) {
		if (kcal>=L) {
			return;
		}
		if (idx == N) {
			if (score>maxScore) {
				maxScore=score;
			}
			return;
		}
		makeBurger(idx+1, score+arr[idx][0], kcal+arr[idx][1]);
		makeBurger(idx+1, score, kcal);
	}
}//end of class
