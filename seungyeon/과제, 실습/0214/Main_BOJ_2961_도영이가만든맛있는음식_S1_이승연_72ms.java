import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2961_도영이가만든맛있는음식_S1_이승연_72ms {
	private static int N;
	private static boolean[] isSelected;
	private static int[] bitter;
	private static int[] sour;
	private static int min_result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 재료의 개수 
		StringTokenizer st;
		
		bitter = new int[N];
		sour = new int[N];
		isSelected = new boolean[N];
		
		min_result = Integer.MAX_VALUE;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		
		subset(0);
		
		System.out.println(min_result);
	}
	
	private static void subset(int cnt) {
		if(cnt == N) {
			int bitter_sum = 0;
			int sour_multiply = 1; 
			
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					bitter_sum += bitter[i];
					sour_multiply *= sour[i];
				}
			}
			
			int result = min_result;
			
			if(bitter_sum != 0) result = Math.abs(bitter_sum-sour_multiply);
			if(min_result > result) min_result = result;
			
			return;
		} 
		
		isSelected[cnt] = false;
		subset(cnt+1); 
		isSelected[cnt] = true;
		subset(cnt+1);
	}
}
