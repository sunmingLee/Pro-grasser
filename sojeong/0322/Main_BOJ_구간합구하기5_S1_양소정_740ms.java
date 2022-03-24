
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_구간합구하기5_S1_양소정_740ms{
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [][]map = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1] + Integer.parseInt(st.nextToken());	
			}
		}
		int x1,x2,y1,y2;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());	
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			check(x1,y1,x2,y2,map);
		}
		System.out.println(sb);
	}

	private static void check(int x1, int y1, int x2, int y2, int[][] map) {
		sb.append(map[x2][y2]-map[x2][y1-1]-map[x1-1][y2]+map[x1-1][y1-1]).append("\n");
	}
		
	

}
