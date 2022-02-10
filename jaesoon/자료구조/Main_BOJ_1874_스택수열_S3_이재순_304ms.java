import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_1874_스택수열_S3_이재순_304ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		int num = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int j = 1; j <= n; j++) {
			stack.push(j);
			sb.append("+\n");
			while (!stack.empty()&&num == stack.peek()) {
				sb.append("-\n");
				stack.pop();
				cnt++;
				if (cnt==n) {
					break;
				}
				num = Integer.parseInt(br.readLine());
			}
		}
		if (stack.empty()) {
			System.out.println(sb);
		}
		else {
			System.out.println("NO");
		}
	}//end of main
}//end of class
