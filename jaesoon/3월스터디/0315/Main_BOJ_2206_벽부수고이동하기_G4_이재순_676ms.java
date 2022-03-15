import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2206_벽부수고이동하기_G4_이재순_676ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N+2][M+2];
		for (int i = 1; i <= N; i++) {
			String line = br.readLine();
			for (int j=0; j < M; j++) map[i][j+1] = line.charAt(j);
		}
		Node[][] nodes = new Node[N+2][M+2];
		for (int i = 1; i <= N; i++) for (int j = 1; j <= M; j++) nodes[i][j] = new Node();
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {1,1});
		nodes[1][1].a = 1;
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		int dis = 2;
		while (!q.isEmpty()) {
			int size = q.size();
			while(size-->0) {
				int[] cur = q.poll();
				for (int i = 0; i < 4; i++) {
					int nr = cur[0] + dr[i];
					int nc = cur[1] + dc[i];
					if ((map[nr][nc]=='0')) {
						if ((nodes[nr][nc].a==0&&nodes[cur[0]][cur[1]].a!=0)||
								(nodes[nr][nc].b==0&&nodes[cur[0]][cur[1]].b!=0)) {
							if (nodes[nr][nc].a==0&&nodes[cur[0]][cur[1]].a!=0) {
								nodes[nr][nc].a = dis;
							}
							if (nodes[nr][nc].b==0&&nodes[cur[0]][cur[1]].b!=0){
								nodes[nr][nc].b = dis;
							}
							q.offer(new int[] {nr, nc});
						}
					}
					else if(map[nr][nc]=='1'&&nodes[cur[0]][cur[1]].a!=0) {
						nodes[nr][nc].b = dis;
						q.offer(new int[] {nr, nc});
					}
				}
			}
			dis++;
		}
		int ans = 0; 
		if (nodes[N][M].a == 0 || nodes[N][M].b == 0) {
			ans = Math.max(nodes[N][M].a, nodes[N][M].b);
		}
		else ans = Math.min(nodes[N][M].a, nodes[N][M].b);
		System.out.println(ans == 0 ? -1 : ans);
	}
	static class Node {
		int a = 0, b = 0;
	}
}
