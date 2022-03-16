import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BOJ_2206_벽부수고이동하기_G4_696ms {
	public static class Loc{
		int r;
		int c; 
		int distance; 
		boolean chance_used;
		
		public Loc(int r, int c, int distance, boolean chance_used) {
			super();
			this.r = r;
			this.c = c;
			this.distance = distance;
			this.chance_used = chance_used;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		int N = Integer.parseInt(str[0]); // 1<=N<=1000
		int M = Integer.parseInt(str[1]); // 1<=M<=1000
		
		int[] dir_r = {-1, 0, 1, 0}; // 위로 가는거 빼는것도 괜찮을듯 
		int[] dir_c = {0, 1, 0, -1}; // 위로 가는거 빼는것도 괜찮을듯 
		
		char[][] map = new char[N+2][M+2];
		boolean[][][] visited = new boolean[N+2][M+2][2];
		
		for(int j=0; j<M+2; j++) {
			map[0][j] = '2';
			visited[0][j][0] = true;
			visited[0][j][1] = true;
			map[N+1][j] = '2';
			visited[N+1][j][0] = true;
			visited[N+1][j][1] = true;
		}
		
		for(int i=0; i<N+2; i++) {
			map[i][0] = '2';
			visited[i][0][0] = true;
			visited[i][0][1] = true;
			map[i][M+1] = '2';
			visited[i][M+1][0] = true;
			visited[i][M+1][1] = true;
		}
		
		for(int i=1, size1=N+1; i<size1; i++) {
			char[] c_arr = br.readLine().toCharArray();
			int idx = 0;
			for(int j=1, size2=M+1; j<size2; j++) {
				map[i][j] = c_arr[idx++];
			}
		}
		
		Queue<Loc> queue = new LinkedList<Loc>();
		queue.offer(new Loc(1, 1, 1, false));
		visited[1][1][0] = true;
		visited[1][1][1] = true;
		boolean flag = false; 
		
		while(!queue.isEmpty()) {
			Loc cur_loc = queue.poll();
			
			if(cur_loc.r == N && cur_loc.c == M) {
				System.out.println(cur_loc.distance);
				flag = true;
				return; 
			}
			
			for(int d=0; d<4; d++) {
				int nr = cur_loc.r + dir_r[d];
				int nc = cur_loc.c + dir_c[d];
			
				if(map[nr][nc] == '0') {
					if(!cur_loc.chance_used && !visited[nr][nc][0]) { // 벽 부순적이 있으면 
						queue.add(new Loc(nr, nc, cur_loc.distance+1, false));
						visited[nr][nc][0] = true; 
					} else if(cur_loc.chance_used && !visited[nr][nc][1]) { // 벽 부순적이 없으면 
						queue.add(new Loc(nr, nc, cur_loc.distance+1, true));
						visited[nr][nc][1] = true; 
 					}
				} else if(map[nr][nc] == '1') {
					if(!cur_loc.chance_used && !visited[nr][nc][1]) { // 벽 부순 적이 없어야 부술 수 있음
						queue.add(new Loc(nr, nc, cur_loc.distance+1, true));
						visited[nr][nc][1] = true;
					}
				}
			}
		}
		
		if(!flag) System.out.println("-1");

	} // end of main
} // end of class
