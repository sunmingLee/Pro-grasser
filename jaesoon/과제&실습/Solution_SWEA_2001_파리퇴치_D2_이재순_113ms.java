import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_2001_파리퇴치_D2_이재순_113ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		//테스트케이스 반복
		for (int testcase = 0; testcase < T; testcase++) {
			sb.append("#").append(testcase+1).append(" ");
			String s = br.readLine();
			//행렬 크기와 파리채 크기 설정
			int N = Integer.parseInt(s.substring(0, 2).trim());
			int M = Integer.parseInt(s.substring(2).trim());
			//배열선언 및 초기화
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				String[] str = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(str[j]);
				}
			}
			int a = N-M+1; //반복수 : a*a
			int max = 0;
			int sum;
			//퇴치 마릿수 계산
			for (int i = 0; i < a; i++) {
				for (int j = 0; j < a; j++) {
					sum = 0;
					int row = i+M;
					int col = j+M;
					for (int r = i; r < row; r++) {
						for (int c = j; c < col; c++) {
							sum += arr[r][c];
						}
					}
					if (sum>max) {
						max = sum;
					}
				}
			}
			sb.append(max).append("\n");
		}
		System.out.print(sb);
	}//end of main
}//end of class