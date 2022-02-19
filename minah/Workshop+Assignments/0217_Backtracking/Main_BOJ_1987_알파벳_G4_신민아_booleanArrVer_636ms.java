import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1987_알파벳_G4_신민아_booleanArrVer_636ms {
	static char[][] board;
	static int maxMove = 0;
	static boolean[] alphaCheck;
	static int row, column;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		row = Integer.parseInt(st.nextToken());
		column = Integer.parseInt(st.nextToken());
		
		board = new char[row][column];
		alphaCheck = new boolean[26];
		
		for(int i=0;i<row;i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		horseMoving(0, 0, 0);
		System.out.print(maxMove);
		
	}
	
	// 어차피 알파벳은 26개이므로 최대 이동 가능한 수는 26이다 : 해당 알파벳에 이동했는지 확인해도 좋음(boolean[] alpha = new boolean[26];)
	private static void horseMoving(int moveCount, int r, int c) {
		
		try {
			
			if(alphaCheck[board[r][c] - 'A']) {
				maxMove = Math.max(maxMove, moveCount);
				return;
			}
			
			alphaCheck[board[r][c] - 'A'] = true;
			
			horseMoving(moveCount+1, r-1, c);
			horseMoving(moveCount+1, r+1, c);
			horseMoving(moveCount+1, r, c+1);
			horseMoving(moveCount+1, r, c-1);
			
			alphaCheck[board[r][c] - 'A'] = false;
		} catch(Exception e) {
		
		}
	}
}
