import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BOJ_2567_색종이2_S4_이재순_80ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());//색종이 수 정수(0<N<=100)
		int[][] arr = new int[100][100];//도화지 100*100생성
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());//색종이의 시작 row 위치
			int c = Integer.parseInt(st.nextToken());//색종이의 시작 col 위치
			for (int i = 0; i < 10; i++,r++,c-=10) { //색종이의 가로길이 10
				for (int j = 0; j < 10; j++,c++) { //색종이의 세로길이 10
					if (arr[r][c]==0) {//0이면 도화지 1이면 겹치는 색종이 하나 이상 존재
						arr[r][c]=1; //도화지일경우 색종이 놓기
					}
				}
			}
		}
		int ans = 0;
		int[] dr = {-1,0,1,0}; 
		int[] dc = {0,1,0,-1}; 
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (arr[i][j]==1) {
					for (int j2 = 0; j2 < 4; j2++) {
						int nr = i+dr[j2];
						int nc = j+dc[j2];
						if (nr>=0&&nr<100&&nc>=0&&nc<100) {
							if (arr[nr][nc]==0) {
								ans++;
							}
						}else ans++;
					}
					
				}
			}
		}
		System.out.println(ans);
	}
}
