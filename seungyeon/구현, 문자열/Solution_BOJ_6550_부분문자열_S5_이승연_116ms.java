import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Solution_BOJ_6550_부분문자열_S5_이승연_116ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input; 

		while((input = br.readLine()) != null) {
			String[] input_arr = input.split(" ");
			
			String s = input_arr[0];
			String t = input_arr[1];
			
			int idx_s = 0;
			boolean result = false; 
			
			for(int i=0; i<t.length(); i++) {
				if(s.charAt(idx_s) == t.charAt(i)) {
					idx_s++;
				}
				if(idx_s == s.length()) {
					result = true;
					break;
				}
			}
			
			if(result) {
				sb.append("Yes");
			} else {
				sb.append("No");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
