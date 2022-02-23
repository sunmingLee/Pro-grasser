package algo_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1759_암호만들기_G5_이승연_80ms {
	private static int vowel_num;
	private static int consonant_num;
	private static char[] output;
	private static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken()); // (3<=L<=C<=15)
		
		char[] input = new char[C];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<C; i++) {
			input[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(input);

		vowel_num = 0;
		consonant_num = 0;
		output = new char[L];
		
		combination(input, L, C, 0, 0);
		
		System.out.print(sb.toString());
	}
	
	public static void combination(char[] input, int L, int C, int cnt, int start) {
		if(cnt == L) {
			if(vowel_num>=1 && consonant_num>=2) {
				for(int i=0; i<L; i++) {
					sb.append(output[i]);
				}
				sb.append("\n");
			}
			return;
		} 
		
		for(int i=start; i<C; i++) {
			if(input[i] == 'a' || input[i] == 'e' || input[i] == 'i' || input[i] == 'o' || input[i] == 'u') {
				vowel_num++;
			} else {
				consonant_num++;
			}
			output[cnt] = input[i];
			combination(input, L, C, cnt+1, i+1);
			if(input[i] == 'a' || input[i] == 'e' || input[i] == 'i' || input[i] == 'o' || input[i] == 'u') {
				vowel_num--;
			} else {
				consonant_num--;
			}
		}
	}
}
