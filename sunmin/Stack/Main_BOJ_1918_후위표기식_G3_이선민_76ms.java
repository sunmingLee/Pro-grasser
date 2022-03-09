package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_1918_후위표기식_G3_이선민_76ms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Stack<Character> stack = new Stack<Character>(); // 연산자를 담을 스택
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i); // 현재 문자
			if (temp >= 'A' && temp <= 'Z') { // 알파벳인 경우
				sb.append(s.charAt(i));
			} else { // 연산자인 경우
				if (temp == '(') {
					stack.push(temp);
				} else if (temp == ')') { // 닫힘 괄호가 올 경우, 열림괄호가 나올때까지 pop
					while (stack.peek() != '(') {
						sb.append(stack.pop());
					}
					stack.pop(); // 남은 '(' 처리
				} else { // 사칙연산 기호의 경우, 스택 속 연산자의 우선순위가 현재 연산자의 우선순위보다 낮을때까지 pop
					while (!stack.isEmpty() && order(stack.peek()) >= order(temp)) {
						sb.append(stack.pop());
					}
					stack.push(temp);
				}
			}
		}	// 수식 모두 받아옴
		
		// 스택에 남은 연산자 출력
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.print(sb.toString());
	} // end of main

	/**
	 * 연산자의 우선순위 리턴
	 */
	private static int order(char operator) {
		switch (operator) {
		case '*':
		case '/':
			return 2;

		case '+':
		case '-':
			return 1;

		case '(':
		case ')':
			return 0;
		}
		return -1;
	} // end of order

} // end of class
