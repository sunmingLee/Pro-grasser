import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BOJ_1987_알파벳_G4_이재순_516ms {
	static int ans;//정답
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());//배열의 row+2입력(한줄 둘러주기)
		int C = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];//전체 배열
		for (int i = 0; i < R; i++) {//배열 초기화
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j)-'A';
			}
		}
		
		ans = 0;//정답 초기화
		dfs(map, 0, 0, 0, 0);//프로세스 진행
		System.out.println(ans);//출력
	}//end of main
	
	private static void dfs(int[][] map,int flag, int r, int c, int distance) {
		try {
			if ((flag&1<<map[r][c])!=0) {//이미 사용한 곳이라면 진행 (배열 넘어가면 여기서 예외 발생)
				if (distance>ans) {//최댓값 갱신
					ans = distance;
				}
				return;
			}
			int tempflag = flag|1<<map[r][c];
			dfs(map, tempflag, r-1, c, distance+1);//상
			dfs(map, tempflag, r, c+1, distance+1);//우
			dfs(map, tempflag, r+1, c, distance+1);//하
			dfs(map, tempflag, r, c-1, distance+1);//좌
		} catch (Exception e) {}
	}
}//end of class
