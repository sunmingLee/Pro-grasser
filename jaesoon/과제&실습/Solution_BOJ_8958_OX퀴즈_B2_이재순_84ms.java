import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_BOJ_8958_OX퀴즈_B2_이재순_84ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			String line = br.readLine();
			int size = line.length();
			int[] score = new int[size];
			if (line.charAt(0)=='O') score[0] = 1;
			int scoreSum = score[0];
			for (int i = 1; i < size; i++) {
				if (line.charAt(i)=='O') {
					score[i] = score[i-1]+1;
					scoreSum += score[i];
				}
			}
			sb.append(scoreSum).append("\n");
		}
		System.out.print(sb);
	}
}
