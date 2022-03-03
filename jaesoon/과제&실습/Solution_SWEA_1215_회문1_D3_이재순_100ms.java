import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_1215_회문1_D3_이재순_100ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc < 11; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[][] map = new char[8][];
			for (int i = 0; i < 8; i++) map[i] = br.readLine().toCharArray();
			int ans = 0;
			for (int i = 0, r = 9-N, rr = N/2; i < 8; i++) {
loop:			for (int k = 0; k < r; k++) {
					for (int j = 0, col = k; j < rr; j++, col++) {
						if (map[i][col]!=map[i][k+N-j-1]) {
							continue loop;
						}
					}
					ans++;
				}
			}
			
			for (int i = 0, r = 9-N, rr = N/2; i < 8; i++) {
loop:			for (int k = 0; k < r; k++) {
					for (int j = 0, row = k; j < rr; j++, row++) {
						if (map[row][i]!=map[k+N-j-1][i]) {
							continue loop;
						}
					}
					ans++;
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
}
