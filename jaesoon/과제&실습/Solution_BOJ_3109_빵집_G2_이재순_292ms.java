import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_BOJ_3109_빵집_G2_이재순_292ms {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken())-1;
		char[][] map = new char[R][];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int ans = 0;
		for (int i = 0; i < R; i++) {
			if (dfs(map, i, 0, C)) {
				ans++;
			}
		}
		System.out.println(ans);
		
	}

	
	private static boolean dfs(char[][] map, int r, int c, int C) {
		try {
			if (map[r][c]=='x') {
				return false;
			}
			map[r][c] = 'x';
			if (c == C) {
				return true;
			}
			
			int nc = c + 1;
			if (dfs(map, r - 1, nc, C) || dfs(map, r, nc, C) || dfs(map, r + 1, nc, C)) {
				return true;
			}
		} catch (Exception e) {}
		return false;
	}
}
