import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2638_치즈_G4_이재순_160ms {
	private static int[][] parents;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//5<=N<=100
		int M = Integer.parseInt(st.nextToken());//5<=M<=100
		parents = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				parents[i][j] = i*1000+j; //i j를 int하나로 표현
			}
		}
		Cheese cheese = null;
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0, idx = 0; j < M; j++, idx+=2) {
				if (line.charAt(idx)=='1') {
					map[i][j] = Integer.MAX_VALUE;
					cheese = new Cheese(i, j, cheese);
				}
				else {
					if (i>0&&map[i-1][j]==0) {
						unionset(i, j, i-1, j);
					}
					if (j>0&&map[i][j-1]==0) {
						unionset(i, j, i, j-1);
					}
				}
			}
		}
		
		
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		int ans = 0;
		while (cheese!=null) {
			ans++;
			Cheese curList = cheese; //탐색할 치즈배열
			cheese = null;//녹지 않는 치즈를 저장
			Cheese meltCheese = null;//녹은 치즈를 저장
			for (Cheese cur = curList; cur !=null; cur = cur.next) {
				int freshair = 0;
				for (int i = 0; i < 4; i++) {
					int nr = cur.r+dr[i];
					int nc = cur.c+dc[i];
					if (map[nr][nc]<ans&&findset(nr,nc,nr*1000+nc)==0) {
						freshair++;
					}
				}
				if (freshair>1) {
					meltCheese = new Cheese(cur.r, cur.c, meltCheese);
				}
				else {
					cheese = new Cheese(cur.r, cur.c, cheese);
				}
			}
			//녹은 치즈와 주변의 공기 union
			for (Cheese cur = meltCheese; cur !=null; cur = cur.next) {
				for (int i = 0; i < 4; i++) {
					int nr = cur.r+dr[i];
					int nc = cur.c+dc[i];
					if (map[nr][nc]<ans) {
						unionset(nr, nc, cur.r, cur.c);
					}
				}
				map[cur.r][cur.c] = ans; //ans시간 후에 녹았다 저장
			}
		}
		System.out.println(ans);
		
	}
	
	private static int findset(int i, int j, int num) {
		if (num == parents[i][j]) {
			return num;
		}
		return parents[i][j] = findset(parents[i][j]/1000, parents[i][j]%1000, parents[i][j]);
	}
	
	private static boolean unionset(int i, int j, int r, int c) {
		int aRoot = findset(i, j, i*1000+j);
		int bRoot = findset(r, c, r*1000+c);
		if (aRoot == bRoot) {
			return false;
		}
		else if (aRoot>bRoot) {
			parents[aRoot/1000][aRoot%1000] = bRoot;
		}
		else {
			parents[bRoot/1000][bRoot%1000] = aRoot;
		}
		return true;
	}
	
	static class Cheese {
		int r, c;
		Cheese next;
		
		public Cheese(int r, int c, Cheese next) {
			super();
			this.r = r;
			this.c = c;
			this.next = next;
		}
	}
}
