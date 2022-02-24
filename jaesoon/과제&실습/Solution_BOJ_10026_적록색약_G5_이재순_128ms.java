import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_BOJ_10026_적록색약_G5_이재순_128ms {
	private static char[][] map;
	private static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	private static boolean[][] visited1, visited2;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new char[N][];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}
		
		visited1 = new boolean[N][N];
		visited2 = new boolean[N][N];
		int ans1 = 0;//일반인이 보는 구역 수
		int ans2 = 0;//적록색약이 보는 구역 수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited1[i][j]) {
					ans1++;
					checkArea1(i, j);
				}
				if (!visited2[i][j]) {
					ans2++;
					checkArea2(i, j);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(ans1).append(" ").append(ans2);
		System.out.print(sb);
	}
	
	private static void checkArea1(int r, int c) {
		visited1[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r+deltas[i][0];
			int nc = c+deltas[i][1];
			try {
				if (!visited1[nr][nc]&&map[r][c]==map[nr][nc]) {
					checkArea1(nr, nc);
				}
			} catch (Exception e) {}
		}
	}
	private static void checkArea2(int r, int c) {
		visited2[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r+deltas[i][0];
			int nc = c+deltas[i][1];
			try {
				if (!visited2[nr][nc]&&(map[r][c]==map[nr][nc]||Math.abs(map[r][c]-map[nr][nc])==11)) {
					checkArea2(nr, nc);
				}
			} catch (Exception e) {}
		}
		
	}
}
