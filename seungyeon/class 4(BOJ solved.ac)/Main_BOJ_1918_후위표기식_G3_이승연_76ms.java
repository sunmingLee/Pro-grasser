import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_1918_후위표기식_G3_이승연_76ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		char[] input = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<Character>(); 
		
		for(int i=0, size=input.length; i<size; i++) {
			if('A'<=input[i] && input[i]<='Z') { // 피연산자면 
				sb.append(input[i]);
			}
			else if(input[i] == '(') { // '('
				stack.push(input[i]);
			}
			else if(input[i] == ')') {
				while(stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop(); // '(' 빼기 
			}
			else { // '+', '-', '*', '/'
//				if(stack.isEmpty() || precedence(input[i]) > precedence(stack.peek())) {
//					stack.push(input[i]);
//				} 
//				else {
//					while(!stack.isEmpty() && precedence(input[i]) <= precedence(stack.peek())) {	
//						sb.append(stack.pop());
//					}
//					stack.push(input[i]);
//				}
				
				while(!stack.isEmpty() && precedence(input[i]) <= precedence(stack.peek())) {	
					sb.append(stack.pop());
				}
				stack.push(input[i]);
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.print(sb.toString());
	}
	
	public static int precedence(char c) {
		if(c == '(') return 0;
		else if(c == '+' || c == '-') return 1; 
		else if(c == '*' || c == '/') return 2; 
		
		return -1;
	}
}
