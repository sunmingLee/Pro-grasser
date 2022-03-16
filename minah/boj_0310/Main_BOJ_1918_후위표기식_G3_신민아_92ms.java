package boj_0310;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_1918_후위표기식_G3_신민아_92ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> op = new Stack<Character>(); // 괄호를 포함한 연산자 저장 스택
		StringBuilder sb = new StringBuilder();
		
		char[] exp = br.readLine().toCharArray(); // char 배열로 만듬
		for(int i=0;i<exp.length;i++) { // char 배열에 있는 모든 원소 돌리기
			char current = exp[i]; // 현재 원소
			switch(current) { // 현재 원소가 어디에 속하나 체크
				case '+' : case '-' : case '*' : case '/' : // 현재 원소가 사칙 연산 중 하나라면
					while(!op.isEmpty() && getPriority(op.peek()) >= getPriority(current)) { // 스택이 비기 전까지 + 현재 원소의 우선 순위가 스택 내의 가장 위에 있는 연산자보다 작거나 같을 때
						sb.append(op.pop()); // 계속 꺼내서 sb에 붙여줌
					}
					op.push(current); // 다 비워준 후에 현재의 연산자를 스택에 넣어줌
					break;
				case '(' :
					op.push(current); // 괄호 시작 시 무조건 스택에 넣어줌
					break;
				case ')' :
					char curOp; // 스택의 가장 위에있던 연산자
					while((curOp = op.pop()) != '(') { // ( 를 만나기 전까지 --> ( 까지 pop하기 때문에 후처리 필요 x
						sb.append(curOp); // 스택 안에 있는 연산자를 sb에 붙여줌
					}
					break;
				default :
					sb.append(current); // 연산자만 저장하고 피연산자는 바로 출력
			}
		}
		
		while(!op.isEmpty()) { // flush
			sb.append(op.pop());
		}
		
		System.out.print(sb.toString());
	}
	
	// 괄호를 포함한 연산자들의 우선 순위를 찾는 메소드
	static private int getPriority(char op) {
		switch(op) {
			case '(' : case ')' : // 괄호는 가장 연산자의 우선 순위가 높으므로
				return 0;
			
			// 원래대로라면 *, / 가 더 우선 순위가 높지만, 다음 연산자가 +-가 stack에 들어오게 되면 안에 스택 안에 남아있는 연산자는 모두 꺼내야 하므로
			// 용이한 계산을 위해 +-한테 높은 순위를 줌
			case '+' : case '-' : 
				return 1;
			default : // * or /
				return 2;
		}
	}
	
}
