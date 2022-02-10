import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_18111_마인크래프트_S2_이재순_352ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//N,M,B 받아오기
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int sum = B; // 사용가능한 블럭의 수
		int min = 257; // 최소 층 
		//배열 생성
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				sum += arr[i][j];
				if (min>arr[i][j]) {
					min = arr[i][j];
				} 
			}
		}
		int max = sum/(N*M); // 주어진 블럭으로 만들 수 있는 가장 높은 층
		int floor = 256; 
		int minTime=Integer.MAX_VALUE;
		int a; // 추가하거나 제거해야하는 블럭의 수
		//max층부터 탐색하며 minTime 갱신이 안되면 break
		for (int k = max; k >= min; k--) {
			sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					a = k-arr[i][j];
					sum += (a < 0) ? -a*2 : a;
				}
			}
			if (minTime > sum) {
				minTime = sum;
				floor = k;
				continue;
			}
			break;
		}
		sb.append(minTime).append(" ").append(floor);
		System.out.print(sb);
	}//end of main
}//end of class
