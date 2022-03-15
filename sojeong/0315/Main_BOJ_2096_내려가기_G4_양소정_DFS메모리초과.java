
import java.io.BufferedReader;
import java.io.InputStreamReader;
//메모리 초과
public class Main_BOJ_2096_내려가기_G4_양소정_DFS메모리초과 {
	private static int max=0;
	private static int min=Integer.MAX_VALUE;
	private static int dx[] = {1,1,1};
	private static int dy[] = {-1,0,1};
	private static int xx;
	private static int yy;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int map[][] = new int [N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0,k=0; j < N; j++,k+=2) {
				map[i][j] = str.charAt(k)-'0';
			}
		}
		
		for (int i = 0; i <N; i++) {	
			dfs(map,0,i,map[0][i],N,0);

		}
		System.out.println(max+" "+min);
	}

	private static void dfs(int[][] map, int x,int y, int sum, int N,int d) {
		if(max<sum) {
			max=sum;
		}
		if(d==N-1 && sum<min) {
			min = sum;
		}
		if(d==N) return;

		for (int i = 0; i < 3; i++) {
			 xx = x+dx[i];
			 yy = y+dy[i];
			if(yy>=0 && xx<N && yy<N) {
				
				dfs(map,xx,yy,sum+map[xx][yy],N,++d);
			}
		}
	}
}
