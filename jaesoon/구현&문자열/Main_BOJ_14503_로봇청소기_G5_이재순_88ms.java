import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14503_로봇청소기_G5_이재순_88ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};//(0:북, 1:동, 2:남, 3:서)
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int way = Integer.parseInt(st.nextToken());//(0:북, 1:동, 2:남, 3:서)
		//배열 생성
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 1;
		int nr, nc;
		arr[r][c] = 2; //청소한 곳은 2로 바꾸기
		boolean a = true; // while문 반복 체크
		boolean b; // 4방향 청소 불가능 = true
		while (a) {
			b = true;
			//4방 탐색
			for (int n = 3; n >-1; n--) {
				int temp = (n+way)%4;
				nr = r+deltas[temp][0];
				nc = c+deltas[temp][1];
				if (arr[nr][nc]==0) {
					r = nr;
					c = nc;
					arr[r][c] = 2;
					cnt++;
					way = temp;
					b = false;
					break;
				}
			}
			if (b) {
				int temp = (2+way)%4;
				r = r+deltas[temp][0];
				c = c+deltas[temp][1];
				//후방이 벽인지 체크
				if (arr[r][c]==1) {
					a = false;
				}
			}
		}
		System.out.println(cnt);
	}//end of main
}//end of class
