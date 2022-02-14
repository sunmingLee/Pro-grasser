

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_3040_백설공주와일곱난쟁이_B2_양소정_76ms{
	private static boolean[] isSelected;
	private static int[] hat;
	private static int[] num = new int[7];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		hat = new int[9];
		isSelected = new boolean[9];
		for (int i = 0; i < 9; i++) {
			hat[i] =Integer.parseInt(br.readLine());
			
		}
		
		com(0,0);
	}

	private static void com(int cnt , int start) {
		if(cnt == 7) {
			int total =0;
			for (int i = 0; i < 7; i++) {
				total += num[i];
			}
			if(total == 100) {
				for (int i : num) {
					System.out.println(i);
				}
			}
			return;
		}
		
		for (int i = start; i < 9; i++) {
			num [cnt] = hat[i];
			com(cnt+1,i+1);
			
		}
		
	}

}
