import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3234_준환이의양팔저울_D4_이승연 {
	private static int N;
	private static boolean[] isSelected;
	private static int left_sum;
	private static int right_sum;
	private static int result;
	private static int[] weights;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase<=T; testCase++) {
			N = Integer.parseInt(br.readLine());
			weights = new int[N];
			isSelected = new boolean[N];
			
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int i=0; i<N; i++) {
				weights[i] = Integer.parseInt(st.nextToken());
			}
			
			left_sum = 0;
			right_sum = 0;
			result = 0;
			
			permutation(0);
			
			sb.append("#").append(testCase).append(" ").append(result).append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	public static void permutation(int cnt) {
		if(left_sum < right_sum) return; 
		if(cnt == N) {
			result++;
			return;
		}

		for(int i=0; i<N; i++) {
			if(isSelected[i]) continue; 
			
			isSelected[i] = true;
			left_sum += weights[i];
			permutation(cnt+1); 
			left_sum -= weights[i];
//			isSelected[i] = false;
//			
//			isSelected[i] = true;
			right_sum += weights[i];
			permutation(cnt+1); 
			right_sum -= weights[i];
			isSelected[i] = false; 
		}
	}
}
