import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_3109_빵집_G5_신민아_300ms {
	static int pathCount = 0;
	static boolean isFoundPath = false;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[row][col];
		
		for(int i=0;i<row;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0;i<row;i++) {
			makePath(map, row, col, i, 0);
			isFoundPath = false;
		}
		
		System.out.print(pathCount);
		
	}
	 
	// 이미 갔던 경로로 가서 길이 막히면 어차피 이후에도 진행을 못하므로 x를 다시 되돌릴 필요는 없다!
	// 가장 좋은 최적해를 찾는 방법은 오른쪽 위 -> 오른쪽 중간 -> 오른쪽 아래로 탐색하는 방법!!
	// isFoundPath 전역변수 설정할 필요 없이 지역변수로 두고 makePath return type을 boolean형으로 두고 내부에 isConnect가 true일 때 탐색 중지 --> 조금 더 빠름!
	private static void makePath(char[][] map, int sizeRow, int sizeCol, int r, int c) {
		try {
			if(map[r][c] == 'x' || isFoundPath) {
				return;
			}
			
			if(c == sizeCol - 1) {
				pathCount++;
				map[r][c] = 'x';
				isFoundPath = true;
				
				return;
			}
			
			map[r][c] = 'x';
			makePath(map, sizeRow, sizeCol, r-1, c+1);
			makePath(map, sizeRow, sizeCol, r, c+1);
			makePath(map, sizeRow, sizeCol, r+1, c+1);
			
		} catch(Exception e) {
			
		}
	}

}
