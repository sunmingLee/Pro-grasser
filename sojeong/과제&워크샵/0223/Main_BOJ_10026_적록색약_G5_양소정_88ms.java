import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_10026_적록색약_G5_양소정_88ms {
	private static int dx[] = {1,0,-1,0};
	private static int dy[] = {0,1,0,-1};
	private static boolean[][] v;
	private static char[][] map;
	
	private static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N]; 
		v = new boolean[N][N]; //방문체크
		int cnt1 =0;
		int cnt2 =0;
		//배열 만들기
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}	
		}
		//일반인 구역
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!v[i][j]) {
					dfs1(i,j);
					cnt1++;				
				}
				if(map[i][j] == 'G') { //색맹 cnt구하기 위해 G를 R로 통합해줌
					map[i][j] ='R';
				}
			}		
		}
		
		//색약 구역
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
		
				if(v[i][j]) {
					dfs1(i,j);
					cnt2++;
				}
			}
		}		
	
		System.out.println(cnt1+" "+cnt2);
	
	}

	private static void dfs1(int x, int y) {
		v[x][y] ^= true; //xor하면 반대됨	
			
		for (int i = 0; i < 4; i++) {
			int xx = x+dx[i];
			int yy = y+dy[i];
			if( xx>=0 && xx<N && yy>=0 && yy<N  //배열 안에 있고
					&& v[x][y]!= v[xx][yy]  	//방문하지 않은 곳이고
							&& map[xx][yy] == map[x][y]) { //색상 같다면
				dfs1(xx,yy);
			}		
		}
		
	}

}
