package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_9935_문자열폭발_G4_이선민_456ms {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine(); // 주어진 문자열
		String bomb = br.readLine(); // 폭발 문자열
		int lineLength = line.length();
		int bombLength = bomb.length();
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < lineLength; i++) {
			stack.push(line.charAt(i));

			if (stack.size() >= bombLength) {
				boolean flag = true;
				
				for (int j = 0; j < bombLength; j++) {	// 스택의 뒷부분 중 폭발 문자열의 길이만큼만 확인
					int start = stack.size() - bombLength + j;
					if (stack.get(start) != bomb.charAt(j)) {
						flag = false;
						break;
					}
				}
				
				if(flag) {	// 폭발 문자열이 있다면 스택에서 제거
					for (int j = 0; j < bombLength; j++) {
						stack.pop();
					}
				}
			}
		}
		
		if (stack.size() == 0) {
			System.out.println("FRULA");
		} else {
			StringBuilder sb = new StringBuilder();
			for (Character character : stack) {
				sb.append(character);
			}
			System.out.print(sb.toString());
		}
	} // end of main

} // end of class
