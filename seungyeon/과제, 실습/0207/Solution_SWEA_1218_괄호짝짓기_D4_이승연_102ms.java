import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_SWEA_1218_괄호짝짓기_D4_이승연_102ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		for(int testCase=1; testCase<=10; testCase++) {
			Stack<Character> stack = new Stack<Character>();
			
			int tc_length = Integer.parseInt(br.readLine());
			String str = br.readLine(); 
			char[] sets_front = {'(', '[', '{', '<'};
			char[] sets_back = {')', ']', '}', '>'};
			
			sb.append("#").append(testCase).append(" ");
			

			for(int i=0; i<tc_length; i++) {
				Character c = str.charAt(i);
				boolean flag = false;

				if(!stack.isEmpty()) {
					for(int j=0; j<sets_front.length; j++) {
						if(c == sets_front[j]) {
							flag = true; 
							stack.push(sets_front[j]);
							break;
						} else if(c == sets_back[j] && stack.peek()==sets_front[j]) {
							stack.pop();
							flag = true;
							break;
						}
					}
					if(!flag) {
						break; 
					}	
				} else {
					stack.push(c);
				}
			}
			
			if(stack.isEmpty()) {
				sb.append("1\n");
			} else {
				sb.append("0\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}
