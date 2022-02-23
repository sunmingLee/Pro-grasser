import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_BOJ_10026_적록색약_G5_이재순_108ms {
	private static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	private static boolean[][][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		//map 초기화
		char[][][] map = new char[2][N][];//0 : 적록색약X의 map, 1 : 적록색약의 map
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			map[0][i] = str.toCharArray();//적록색약이 아닌 사람의 map 초기화
			map[1][i] = str.replace('R', 'G').toCharArray();//적록색약의 map 초기화
		}
		visited = new boolean[2][N][N];//0 : 적록색약X의 방문관리, 1 : 적록색약의 방문관리
		
		//프로세스 진행
		int ans1 = 0;//적록색약이 아닌 사람이 보는 구역 수
		int ans2 = 0;//적록색약이 보는 구역 수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[0][i][j]) {//아직 방문하지 않은 곳이면 진행
					ans1++;//구역 증가
					checkArea(i, j, map[0], map[0][i][j], 0);//탐색
				}
				if (!visited[1][i][j]) {
					ans2++;//구역 증가
					checkArea(i, j, map[1], map[1][i][j], 1);//탐색
				}
			}
		}
		
		//출력
		StringBuilder sb = new StringBuilder();
		sb.append(ans1).append(" ").append(ans2);
		System.out.print(sb);
	}
	/** 같은 구역을 모두 방문하는 메소드, r : row, c : col, map: 탐색하는 배열, cur : 현재 구역의 RGB, who : 0이면 적록색약X, 1이면 적록색약*/
	private static void checkArea(int r, int c, char[][] map, char cur, int who) {
		visited[who][r][c] = true;//방문체크
		for (int i = 0; i < 4; i++) {//4방 탐색
			int nr = r+deltas[i][0];//탐색할 row값
			int nc = c+deltas[i][1];//탐색할 col값
			try {
				if (!visited[who][nr][nc]&&map[nr][nc]==cur) {//탐색할 곳이 아직 방문하지 않은곳이고 현재칸과 같은 구역이라면 진행
					checkArea(nr, nc, map, cur, who);
				}
			} catch (Exception e) {}
		}
	}
}
