package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BOJ_1406_에디터_S3_양소정_520ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());
    // 커서 기준 오른쪽 왼쪽 스택
		Stack<String> leftSt = new Stack<String>();
		Stack<String> rightSt = new Stack<String>();
		
		for (int i = 0; i < str.length(); i++) {
			leftSt.push(String.valueOf(str.charAt(i)));
			
		}
		
		for(int i = 0; i < M; i++) {
			String cmd = br.readLine();
			char c = cmd.charAt(0);  
			
			switch(c) {
			case 'L': //커서 왼쪽으로
				if(!leftSt.isEmpty())  //문장 맨앞이면 무시
					rightSt.push(leftSt.pop());

				break;
			case 'D': // 커서 오른쪽으로
				if(!rightSt.isEmpty())
					leftSt.push(rightSt.pop());

				break;
			case 'B':  //커서 왼쪽 삭제
				if(!leftSt.isEmpty()) {
					leftSt.pop();
				}
				break;
			case 'P':  //t 커서 왼쪽 추가
				char t = cmd.charAt(2);
				leftSt.push(String.valueOf(t));

				break;
			default:
				break;
			}
		}
        
		//Stack은 LIFO 구조이기 때문에
		//왼쪽 스택에 있는 데이터들을 모두 오른쪽으로 옮긴 뒤에 오른쪽에 있는 모든 내용을 출력
		while(!leftSt.isEmpty()) {
			rightSt.push(leftSt.pop());
		}
		while(!rightSt.isEmpty()) {
			sb.append(rightSt.pop());
		}
		System.out.println(sb);
		
	}
}
