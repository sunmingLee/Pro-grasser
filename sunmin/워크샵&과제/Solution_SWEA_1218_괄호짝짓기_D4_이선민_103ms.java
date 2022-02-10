import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.EmptyStackException;
import java.util.Stack;

public class Solution_SWEA_1218_괄호짝짓기_D4_이선민_103ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		아래는 따로 만든 테스트케이스
//		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\SM-LEE\\git\\seoul17_hw_leesunmin\\0207\\src\\input.txt"));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		boolean isOkay = false; // 테스트 케이스가 유효하면 true, 유효하지 않으면 false

		for (int testCase = 1; testCase <= 10; testCase++) {
			int l = Integer.parseInt(br.readLine()); // 테스트케이스의 길이
			int answer = 1;
			String s = br.readLine(); // 테스트 케이스

//			기타 아이디어
//			1. 괄호를 if문 내에서 써서 비교하는게 아니라 char[][] 배열안에 괄호의 짝을 맞춰서 미리 넣어두고 비교한다.
			for (int i = 0; i < l; i++) {
				// 열림 괄호면 push
				if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '<') {
					stack.push(s.charAt(i));
					continue;
				}

				// 닫힘 괄호가 오면 우선 스택에 남아있는 괄호가 있는지 확인
				if (stack.empty()) {
					answer = 0;
					break;
				}

				// 스택에 원소가 남아있고 열림괄호가 아니라면 pop한게 현재 괄호와 짝이 맞는지 확인
				char top = stack.pop();
				if ((top == '(' && s.charAt(i) != ')') || (top == '[' && s.charAt(i) != ']')
						|| (top == '{' && s.charAt(i) != '}' || (top == '<' && s.charAt(i) != '>'))) {
					answer = 0;
					break;
				}

			}

			// stack에 저장된 괄호가 모두 짝이 맞았다면
			if (answer != 0 && stack.empty()) {
				answer = 1;
			}
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");

			// 테스트케이스 하나 완료한뒤에는 stack 비워주기
			stack.clear();
		} // end of testCase
		System.out.print(sb);
	} // end of main

} // end of class
