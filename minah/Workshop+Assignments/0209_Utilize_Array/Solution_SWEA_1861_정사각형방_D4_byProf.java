import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// recursion 사용
public class Solution_SWEA_1861_정사각형방_D4_byProf {

	private static int[][] room;
	private static int N;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // 파라미터로 int형을 보내면 크기를 정할 수 있음
		int TC = Integer.parseInt(br.readLine());
		
		for(int testCase=1;testCase<=TC;testCase++) {
			N = Integer.parseInt(br.readLine());
			room = new int[N][N];
			
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
		int result = 1;
		int num = room[r][c];
		for(int i=0;i<dr.length;i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			// nr과 nc가 방의 범위 안에 있는지
			// 시간 줄이는 방법  1. 방의 배열의 테두리에 1줄씩 감싸기, 2.아래 if문에서 범위를 계산하는 조건문을 줄이고 try-catch문 사용
			if((nr >= 0 && nr < N && nc >= 0 && nc < N) && room[nr][nc] == num + 1) { // 현재 방보다 다음 방이 1 큰가
				result += go(nr, nc);
				break; // break의 유무로 인해 250ms나 400ms로 가능, memoization(값을 저장하여 다시 사용하는 기법)을 이용하면 140ms로 줄일 수 있음
			}
		}
		
		return result; // r,c에서 출발해서 최대 이동할 수 있는 방의 개수 리턴
	}
}
