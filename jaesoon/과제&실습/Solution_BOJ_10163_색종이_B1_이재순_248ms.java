import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_BOJ_10163_색종이_B1_이재순_248ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());// 색종이 수 정수(0<N<=100)
		int[][] arr = new int[1001][1001];// 도화지 1001*1001생성
		for (int i = 0; i < 1001; i++) {
			Arrays.fill(arr[i], -1);
		}
		StringTokenizer st;
		int[] paper = new int[N];
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());// 색종이의 시작 row 위치
			int c = Integer.parseInt(st.nextToken());// 색종이의 시작 col 위치
			int w = Integer.parseInt(st.nextToken()) + r;
			int h = Integer.parseInt(st.nextToken()) + c;
			for (int i = r; i < w; i++) { // 색종이의 가로길이 10
				for (int j = c; j < h; j++) { // 색종이의 세로길이 10
					arr[i][j] = n; // 도화지일경우 색종이 놓기
				}
			}
		}
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				if (arr[i][j]!=-1) {
					paper[arr[i][j]]++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(paper[i]).append("\n");
			
		}

		System.out.print(sb); // 색종이들의 넓이 출력
	}
}
