import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_BOJ_16926_배열돌리기1_S2_이재순_604ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//배열의 row수, 2 ≤ N ≤ 300
		int M = Integer.parseInt(st.nextToken());//배열의 col수, 2 ≤ M ≤ 300
		int R = Integer.parseInt(st.nextToken());//회전 수, 1 ≤ R ≤ 1,000
		String[][] arr = new String[N][M]; // 입력된 배열 생성
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().split(" ");
		}
		
		int repeat = Integer.min(N, M)/2; // 반복레이어의 갯수 (min(N,M)%2=0)
		for (int k = 0; k < R; k++) {// 회전 수 만큼 반복
			int r = 0;
			int c = 0;
			for (int i = 0; i < repeat; i++) {//레이어의 수만큼 반복
				String temp = arr[r][c];
				for (int j = 1; j < M-i*2; j++) { // 우로이동
					arr[r][c] = arr[r][++c];
				}
				for (int j = 1; j < N-i*2; j++) { // 하로이동
					arr[r][c] = arr[++r][c];
				}
				for (int j = 1; j < M-i*2; j++) { // 좌로이동
					arr[r][c] = arr[r][--c];
				}
				for (int j = 1; j < N-i*2; j++) { // 상으로이동
					arr[r][c] = arr[--r][c];
				}
				arr[++r][c++] = temp; // r,c에있던 원소를 마지막 자리에 넣어주며 시작지점 r,c에 +1해주어 다음 반복 준비 
			}
		}
		//출력
		for (String[] strings : arr) {
			for (String strings2 : strings) {
				sb.append(strings2).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
