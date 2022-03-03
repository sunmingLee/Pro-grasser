import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_BOJ_17413_단어뒤집기2_S3_이재순_196ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int size = line.length();
		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			switch (line.charAt(i)) {
			case ' ':
				while (!stack.isEmpty()) sb.append(stack.pop());
				sb.append(' ');
				break;
			case '<':
				while (!stack.isEmpty()) sb.append(stack.pop());
				int a = i;
				while (line.charAt(i)!='>') i++;
				sb.append(line.substring(a, i+1));
				break;

			default:
				stack.push(line.charAt(i));
				break;
			}
		}
		while (!stack.isEmpty()) sb.append(stack.pop());
		System.out.println(sb);
	}
}
