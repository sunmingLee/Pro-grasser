import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_1289_원재의메모리복구하기_D3_이승연_108ms{
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        
        String line; 
        int line_length; 
        char cur_char;
        int result; 

		for(int test_case = 1; test_case <= T; test_case++){
            result = 0; 
	        cur_char = '0';
            
            line = br.readLine();
            line_length = line.length();
            
            for(int i=0; i<line_length; i++) {
                if(line.charAt(i)!=cur_char) {
                    result++;
                    cur_char = line.charAt(i);
                }
            }
            
            System.out.println("#"+test_case+" "+result);
		}
	}
}
