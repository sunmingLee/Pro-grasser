import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1987_알파벳_G4_이승연_776ms {
	private static int R;
	private static int C;
	private static char[][] board;
	private static boolean[] alpha;
	private static int[][] dir;
	private static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken()); // (1<=R<=20)
		C = Integer.parseInt(st.nextToken()); // (1<=C<=20)
		
		board = new char[R+2][C+2];
		alpha = new boolean[26];
		
		dir = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
		
//		for(int i=1; i<=R; i++) {
//			board[i] = br.readLine().toCharArray();
//		}
		
		for(int i=1; i<=R; i++) {
			String str = br.readLine();
			for(int j=1; j<=C; j++) {
				board[i][j] = str.charAt(j-1);
			}
		}
		
		for(int i=0; i<=C+1; i++) {
			board[0][i] = board[1][1];
			board[R+1][i] = board[1][1];
		}
		for(int i=0; i<=R+1; i++) {
			board[i][0] = board[1][1];
			board[i][C+1] = board[1][1];
		}
	
		max = 0;
		
		calcMax(1, 1, 0);
		
		System.out.println(max);
	}
	
	public static void calcMax(int sr, int sc, int cnt) {
		cnt++;
		alpha[board[sr][sc]-'A'] = true;
		
		boolean flag = false;
		
		for(int d=0; d<4; d++) {
			if(!alpha[board[sr+dir[d][0]][sc+dir[d][1]]-'A']) {
				flag = true; 
				calcMax(sr+dir[d][0], sc+dir[d][1], cnt);
				flag = false; 
			}
		}
		
		if(!flag) { // 상하좌우 아무데도 갈 수 없을 때, 말이 지날 수 있는 최대 칸 수가 현재 최대 칸 수보다 크면  
			max = Math.max(max, cnt);
			alpha[board[sr][sc]-'A'] = false;
			return; 
		}
	}
}
