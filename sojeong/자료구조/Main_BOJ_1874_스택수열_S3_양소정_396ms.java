import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BOJ_1874_스택수열_S3_양소정_396ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();	
		int n = Integer.parseInt(br.readLine());//수열의 크기
		Stack<Integer> stack = new Stack<Integer>();
		int start = 0;
		for(int a = 0; a<n; a++) {
			int var = Integer.parseInt(br.readLine()); //push해야 될 값
			
			if(var > start) { //push 해야될 값보다 작다면 그 이하 값까지 다 push
				for(int i = start + 1; i<= var; i++) {
					stack.push(i);
					sb.append("+").append("\n");
				}
				start = var; //다음 값으로 초기화
			}else if(stack.peek()!=var) {
				System.out.println("NO");
				return;
			}
			stack.pop();
			sb.append("-").append("\n");
		}
		
		System.out.println(sb);
	}
}


