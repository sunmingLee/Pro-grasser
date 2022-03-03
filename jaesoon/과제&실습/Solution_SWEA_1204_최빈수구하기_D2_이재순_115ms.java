import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1204_최빈수구하기_D2_이재순_115ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int tc = 0; tc < T; tc++) {
			sb.append("#").append(br.readLine()).append(" ");
			st = new StringTokenizer(br.readLine()," ");
			int[] score = new int[101];
			for (int i = 0; i < 1000; i++) score[Integer.parseInt(st.nextToken())]++;
			int ans = 0;
			for (int i = 0, max = 0; i < 101; i++) {
				if (max<=score[i]) {
					ans = i;
					max = score[i];
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
