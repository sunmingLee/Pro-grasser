import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1987_알파벳_G4_신민아_1952ms {
	static char[][] board;
	static int maxMove = 0;
	static int[] movePath = new int[400];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int row = Integer.parseInt(st.nextToken());
		int column = Integer.parseInt(st.nextToken());
		
		board = new char[row][column];
		
		for(int i=0;i<row;i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		horseMoving(0, 0, 0);
		System.out.print(maxMove);
		
	}
	
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	// 어차피 알파벳은 26개이므로 최대 이동 가능한 수는 26이다 : 해당 알파벳에 이동했는지 확인해도 좋음(boolean[] alpha = new boolean[26];)
	private static void horseMoving(int moveCount, int r, int c) {		
		if(isAlphabetContain(moveCount, board[r][c])) {
			maxMove = Math.max(maxMove, moveCount);
			return;
		}
		
		// 이동한 경로를 배열에 저장
		movePath[moveCount] = board[r][c];
		
		for(int i=0;i<4;i++) {
			if(r+dr[i] < board.length && c+dc[i] < board[0].length && r+dr[i] >= 0 && c+dc[i] >= 0) {
				horseMoving(moveCount+1, r+dr[i], c+dc[i]);	
			}
			
		}
	}
	
	// 배열에 이미 해당 알파벳이 있는지 체크
	private static boolean isAlphabetContain(int moveCount, char now) {
		for(int i=0;i<moveCount;i++) {
			if(movePath[i] == now) {
				return true;
			}
		}
		return false;
	}

}
