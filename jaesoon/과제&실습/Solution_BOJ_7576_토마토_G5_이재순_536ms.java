import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_BOJ_7576_토마토_G5_이재순_536ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[M][N];
		Queue<int[]> q = new ArrayDeque<int[]>(); 
		boolean[][] visited = new boolean[M][N];
		int cnt=0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j]==0) cnt++;
				else if (map[i][j]==1) {
					q.offer(new int[] {i,j});
					visited[i][j] = true;
				}
			}
		}
		if (cnt==0) {
			System.out.println(0);
			return;
		}
		int ans = 0;
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		while (!q.isEmpty()) {
			ans++;
			int qSize = q.size();
			for (int i = 0; i < qSize; i++) {
				int[] cur = q.poll();
				for (int j = 0; j < 4; j++) {
					int nr = cur[0] + dr[j];
					int nc = cur[1] + dc[j];
					if (nr>=0&&nr<M&&nc>=0&&nc<N&&!visited[nr][nc]&&map[nr][nc]==0) {
						visited[nr][nc] = true;
						q.offer(new int[] {nr, nc});
						if(--cnt==0) {	
							System.out.println(ans);
							return;
						}
					}
				}
			}
		}
		System.out.println(-1);
	}
}
