package boj_0322;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_9935_문자열폭발_G4_신민아_440ms {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] ex = br.readLine().toCharArray();
		
		int size = str.length();
		Stack<Character> stack = new Stack<Character>();
		Stack<Integer> offsets = new Stack<Integer>();
		int check = 0;
		
		for(int i=0;i<size;i++) {
			char cur = str.charAt(i);
			stack.push(cur);
			if(cur == ex[check]) {
				check++;
			} else {
				if(check > 0) {
					if(cur == ex[0]) {
						offsets.push(check);
						check = 1;
					} else {
						check = 0;
						while(!offsets.isEmpty()) {
							offsets.pop();
						}
					}
				}
			}
			
			if(check == ex.length) {
				for(int c=0;c<check;c++) {
					stack.pop();
				}
				if(!offsets.isEmpty())
					check = offsets.pop();
				else
					check = 0;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		size = stack.size();
		for(int i=0;i<size;i++) {
			sb.append(stack.get(i));
		}
		System.out.print(sb.length() == 0 ? "FRULA" : sb.toString());
	}

}
