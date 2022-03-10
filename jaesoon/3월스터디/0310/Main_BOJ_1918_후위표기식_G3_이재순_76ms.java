import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_1918_후위표기식_G3_이재순_76ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		Stack<Character> ans = new Stack<>(); 
		
		postfix(ans, 0, line, line.length());
		StringBuilder sb = new StringBuilder();
		for (Character character : ans) sb.append(character);
		System.out.println(sb);
	}
	private static int postfix(Stack<Character> ans, int start, String line, int size) {
		Stack<Character> symbol = new Stack<>(); 
		for (int i = start, end = size-1; i < size; i++) {
			switch (line.charAt(i)) {
			case '(':
				i = postfix(ans, i+1, line, size);
				break;
			case ')':
				while (!symbol.isEmpty()) ans.add(symbol.pop());
				return i;
			case '*':
			case '/':
				if (!symbol.isEmpty()&&(symbol.peek()=='*'||symbol.peek()=='/')) {
					ans.add(symbol.pop());
				}
				symbol.add(line.charAt(i));
				break;
			case '+':
			case '-':
				while (!symbol.isEmpty()) ans.add(symbol.pop());
				symbol.add(line.charAt(i));
				break;

			default:
				ans.add(line.charAt(i));
				break;
			}
			if (i == end) while (!symbol.isEmpty()) ans.add(symbol.pop());
		}
		return 0;
	}
}
