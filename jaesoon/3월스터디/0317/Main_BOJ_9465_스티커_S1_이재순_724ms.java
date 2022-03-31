import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_9465_스티커_S1_이재순_724ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 0; tc < T; tc++) {
			
			int n = Integer.parseInt(br.readLine());
			int[][] sticker = new int[2][n+1];
			
			String[] line1 = br.readLine().split(" ");
			String[] line2 = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				sticker[0][i] = Integer.parseInt(line1[i]);
				sticker[1][i] = Integer.parseInt(line2[i]);
			}
			for (int i = n; i > 1; i--) {
				sticker[0][i-2] += Math.max(sticker[1][i-1], sticker[1][i]);
				sticker[1][i-2] += Math.max(sticker[0][i-1], sticker[0][i]);
			}
			
			sb.append(Math.max(sticker[0][0], sticker[1][0])).append("\n");
		}
		System.out.print(sb);
	}
}
