import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BOJ_2309_일곱난쟁이_B2_양소정_88ms {
	private static int[] num = new int[7];
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int []h= new int[9];
			for (int i = 0; i < h.length; i++) {
				h[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(h);
			com(0,0,h,0);
			
			
		}
	
		private static void com(int cnt,int start,int []h,int sum) {
			if(cnt==7) {		
				if(sum == 100) {
					for(int i : num) {
						System.out.println(i);	
					}
					System.exit(0); //안해주면 100인 경우가 여러개 일 때 출력 여러개 됨
				}
				return;
			}
			
			for (int i = start; i < 9; i++) {
				num [cnt] = h[i];
				com(cnt+1,i+1,h,sum+h[i]);
				
			}
			
		}

}
