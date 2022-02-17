package 빵집;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_3109_빵집_G2_양소정_320ms{

	
	private static int []dx= {-1,0,1};
	private static int []dy= {1,1,1};
	private static int R;
	private static int C;
	private static char [][]map;
	private static boolean[][] memo;

	
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		memo = new boolean[R][C];
	    int count = 0;
		for (int i = 0; i < R; i++) {
			if(dfs(i,0)) count++;
		}	
		System.out.println(count);
		
	}
	public static boolean dfs(int x, int y) {
		
		for (int i = 0; i <3 ; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if(xx >= 0 && yy >= 0 && xx < R && yy < C) {
                if(memo[xx][yy] == false && map[xx][yy] == '.') {
                    memo[xx][yy] = true;
                    if(yy == C - 1) return true;
                    if(dfs(xx, yy)) return true;
                }
            }
        }
        return false;
    }    
}
