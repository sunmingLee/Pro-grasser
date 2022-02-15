import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// recursion 사용
public class Solution_SWEA_1861_정사각형방_D4_MemoizationVer {

	private static int[][] room, memo;
	private static int N;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // 파라미터로 int형을 보내면 크기를 정할 수 있음
		int TC = Integer.parseInt(br.readLine());
		
		for(int testCase=1;testCase<=TC;testCase++) {
			N = Integer.parseInt(br.readLine());
			room = new int[N][N];
			memo = new int[N][N]; // 메모이제이션 : 계산 결과를 저장하는 배열
			
			for(int i=0;i<room.length;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=0;j<room.length;j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			int num = Integer.MAX_VALUE;
			for(int r=0;r<room.length;r++) {
				for(int c=0;c<room.length;c++) {
					int val = go(r, c);
					if(max < val) {
						max = val;
						num = room[r][c];
					}
				}
			}
			sb.append("#").append(testCase).append(" ").append(num).append(" ").append(max).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	/** r,c 위치에서 시작해서 이동할 수 있는 최대 방의 개수를 리턴 */
	public static int go(int r, int c) {
		if(memo[r][c] > 0) { // 중복 호출 제거
			return memo[r][c];
		}
		memo[r][c] = 1;
		int num = room[r][c];
		for(int i=0;i<dr.length;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if((nr >= 0 && nr < N && nc >= 0 && nc < N) && room[nr][nc] == num + 1) {
				memo[r][c] += go(nr, nc);
				break;
			}
		}
		
		return memo[r][c]; // r,c에서 출발해서 최대 이동할 수 있는 방의 개수 리턴
	}
}
