import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_7236_저수지의물의총깊이구하기_D3_이재순_97ms {
	public static void main(String[] args) throws Exception {
		int[] dr = {-1,-1,-1,0,0,1,1,1}, dc = {-1,0,1,-1,1,-1,0,1};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
loop:	for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[][] map = new char[N+2][N+2];
			for (int i = 1; i <= N; i++) {
				String line = br.readLine();
				for (int j = 1, idx = 0; j <= N; j++, idx+=2) map[i][j] = line.charAt(idx);
			}
			int ans = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1,temp = 0; j <= N; j++, temp = 0) {
					if (map[i][j] == 'W') {
						for (int k = 0; k < 8; k++) if (map[i+dr[k]][i+dc[k]] == 'W') temp++;
						if (temp==8) {
							sb.append("#").append(tc).append(" 8\n");
							continue loop;
						}
						if (temp==0) temp = 1;
						if (temp>ans) ans = temp;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
}
