import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_BOJ_1874_스택수열_S3_이승연_336ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		
		int cur_n = 0;
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(stack.isEmpty() || stack.peek()<num) {
				while(cur_n != num) {
					stack.push(++cur_n);
					sb.append("+").append("\n");
				}
				stack.pop();
				sb.append("-").append("\n");
				
			} else if(stack.peek()==num){
				stack.pop();
				sb.append("-").append("\n");
			} else {
				sb.setLength(0);
				sb.append("NO");
				break;
			}
		}
		
		System.out.println(sb.toString());
	}
}
