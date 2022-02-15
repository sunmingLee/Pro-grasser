import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_3040_백설공주와일곱난쟁이_B2_이승연_76ms {
	private static int[] input_dwarfs;
	private static int[] output_dwarfs;
	private static boolean flag = false; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		input_dwarfs = new int[9];
		output_dwarfs = new int[7];
		
		for(int i=0; i<9; i++) {
			input_dwarfs[i] = Integer.parseInt(br.readLine());
		}
		
		combination(0, 0);
		
		for(int i: output_dwarfs) sb.append(i).append("\n");
		
		System.out.print(sb.toString());
	}
	
	private static void combination(int cnt, int start) {
		if(cnt == 7) {
			int result = 0;
			for(int i: output_dwarfs) {
				result += i;
			}
			if(result == 100) {
				flag = true;
			}
			return; 
		}
		
		for(int i=start; i<9; i++) {
			output_dwarfs[cnt] = input_dwarfs[i];
			combination(cnt+1, i+1);
			
			if(flag == true) return; 
		}
	}
}
