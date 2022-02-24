import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution_BOJ_16236_아기상어_G3_이재순_180ms {
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int N, size;
	static int[][] map, distance;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int r = 0;
		int c = 0;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0, idx = 0; j < N; j++, idx+=2) {
				map[i][j] = line.charAt(idx)-'0';
				if (map[i][j]==9) {
					map[i][j]=0;
					r = i;
					c = j;
				}
			}
		}
		size = 2;
		int ans = 0;
		while (true) {
			for (int k = 0; k < size; k++) {
				distance = new int[N][N];
				for (int i = 0; i < N; i++) {
					Arrays.fill(distance[i], -1);
				}
				setDistance(r, c);
				int min = Integer.MAX_VALUE;
				boolean flag = false;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(map[i][j]<size&&map[i][j]>0&&distance[i][j]>0&&distance[i][j]<min) {
							min = distance[i][j];
							r = i;
							c = j;
							flag = true;
						}
					}
				}
				if (!flag) {
					System.out.println(ans);
					return;
				}
				map[r][c]=0;
				ans+=distance[r][c];
			}
			size++;
		}
	}
	private static void setDistance(int r, int c) {
		distance[r][c] = 0;
		int depth = 0;
		Queue<Integer[]> q = new ArrayDeque<Integer[]>();
		q.add(new Integer[] {r,c});
		while (!q.isEmpty()) {
			depth++;
			int qSize = q.size();
			for (int i = 0; i < qSize; i++) {
				Integer[] temp = q.poll();
				for (int j = 0; j < 4; j++) {
					int nr = temp[0]+dr[j];
					int nc = temp[1]+dc[j];
					if (nr<N&&nr>=0&&nc<N&&nc>=0&&map[nr][nc]<=size&&distance[nr][nc]==-1) {
						distance[nr][nc] = depth;
						q.add(new Integer[] {nr, nc});
					}
				}
				
			}
		}
	}
}
