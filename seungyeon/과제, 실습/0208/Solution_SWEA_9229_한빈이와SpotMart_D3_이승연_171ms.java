import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_9229_한빈이와SpotMart_D3_이승연_171ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase<=TC; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int snack_num = Integer.parseInt(st.nextToken());
			int max_weight = Integer.parseInt(st.nextToken()); 
			int result = -1;
			
			st = new StringTokenizer(br.readLine(), " ");
			
			int[] snack_weight = new int[snack_num];
					
			for(int i=0; i<snack_num; i++) {
				snack_weight[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<snack_num; i++) {
				for(int j=i+1; j<snack_num; j++) {
					int sum = snack_weight[i] + snack_weight[j];
					if(sum <= max_weight && sum > result) {
						result = sum;
					}
				}
			}
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
}
