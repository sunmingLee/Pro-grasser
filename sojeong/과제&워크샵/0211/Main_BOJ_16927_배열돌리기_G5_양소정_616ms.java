
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_16926_배열돌리기_S2_양소정_420ms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		int[][] arr = new int[N][M];
		//배열만들기
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count = Math.min(N, M) / 2; //(작은수/2)가 돌려야할 라인의 수
		for(int rot=0; rot<R; rot++) { //회전 횟수만큼 반복
			
			for(int i=0; i<count; i++) { //라인들 전부 돌리기
				int temp = arr[i][i]; //따로 저장
				
				for(int j=i+1; j<M-i; j++) // <- 
					arr[i][j-1] = arr[i][j];
				
				for(int j=i+1; j<N-i; j++) //↑
					arr[j-1][M-1-i] = arr[j][M-1-i];
				
				for(int j=M-2-i; j>=i; j--)//->
					arr[N-1-i][j+1] = arr[N-1-i][j];
				
				for(int j=N-2-i; j>=i; j--)
					arr[j+1][i] = arr[j][i]; //↓
				
				arr[i+1][i] = temp;
			}
		}
		//출력
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
