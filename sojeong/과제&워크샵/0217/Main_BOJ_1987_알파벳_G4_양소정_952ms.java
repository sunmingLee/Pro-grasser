import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1987_알파벳_G4_양소정_952ms{
	private static int []dx= {-1,0,1,0};
	private static int []dy= {0,1,0,-1};
	private static int R;
	private static int C;
	private static int [][]map;
	private static boolean[] visit;
	private static int ans = 1;

	
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		
		map = new int[R+2][C+2];
		for (int i = 1; i <= R; i++) {
			String str = br.readLine();
			for (int j = 1; j <= C; j++) {
				map[i][j] = str.charAt(j-1) - '@'; //아스키코드 A가 97 @가 96 이라 빼면 A 1부터 저장 
													                //테두리가 0이라서 1부터 저장하게 했음
			}
		}
		visit = new boolean[R*C+1];
		
		dfs(1,1,0);
		System.out.println(ans);
		
	}
	public static void dfs(int x, int y ,int cnt) {
		if(visit[map[x][y]]) {
			ans  = Math.max(ans, cnt);
			return;
		}else {
			
			visit[map[x][y]] =true;
			for (int i = 0; i <4 ; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				if(map[xx][yy]!=0 ) { //테두리
					
					dfs(xx,yy,cnt+1);
					
				}	
			}
			visit[map[x][y]] =false;
		}
	}
}
