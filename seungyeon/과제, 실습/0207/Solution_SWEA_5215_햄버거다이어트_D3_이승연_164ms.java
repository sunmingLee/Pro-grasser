import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_5215_햄버거다이어트_D3_이승연_164ms {
	private static int N;
	private static int L;
	private static int[] input_score;
	private static int[] input_cal;
	private static int max_score_sum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase<=TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			input_score = new int[N];
			input_cal = new int[N];
			max_score_sum = 0;
			
			sb.append("#").append(testCase).append(" ");
					
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				input_score[i] = Integer.parseInt(st.nextToken());
				input_cal[i] = Integer.parseInt(st.nextToken());
			}
			
			findMaxScore(0, 0, 0);
			sb.append(max_score_sum).append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	public static void findMaxScore(int cnt, int cur_score_sum, int cur_cal_sum) {
		if(cur_cal_sum > L) return; 
		else if(cnt == N) {
			if(max_score_sum < cur_score_sum) max_score_sum = cur_score_sum;
			return; 
		}
		
		findMaxScore(cnt+1, cur_score_sum+input_score[cnt], cur_cal_sum+input_cal[cnt]);
		findMaxScore(cnt+1, cur_score_sum, cur_cal_sum);
	}
}
