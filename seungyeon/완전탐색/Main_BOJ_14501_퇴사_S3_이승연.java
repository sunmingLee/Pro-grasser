import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14501_퇴사_S3_이승연 {
	private static int N;
	private static int[][] consult;
	private static int max;
	private static int temp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 상담 가능 일수 (1<=N<=15)
		consult = new int[N+1][2];
		
		StringTokenizer st; 
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			consult[i][0] = Integer.parseInt(st.nextToken());
			consult[i][1] = Integer.parseInt(st.nextToken());
		}
		
		max = 0;
		temp = 0;
		
		calcMaxProfit(1);
		
		System.out.println(max);
	}
	
	public static void calcMaxProfit(int idx) {
		if(idx > N) {
			max = Math.max(max, temp);
			return; 
		}
		
		for(int i=idx; i<=N; i++) {
			if(i+consult[i][0] > N+1) continue;
		
			temp += consult[i][1];
			calcMaxProfit(i+consult[i][0]);
			temp -= consult[i][1];
		}
	}
}
