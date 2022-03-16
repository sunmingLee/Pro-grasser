package march0310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/*
반례 A*B+C+D+E*F*G+E 
답 AB*C+D+EF*G*+E+   

while문 돌릴때 EmptyStack 먼저 검사
*/
public class Main_BOJ_1918_후위표기식_G3_양소정_76ms{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine(); //입력
		StringBuilder sb = new StringBuilder();
		Stack<Character> st = new Stack<Character>();
	
	
		for (char arr: str.toCharArray()) {
			
			if(arr =='(') {
				st.push('0'); //괄호 0값 stack에 넣어서 구분
				continue;
			}
			if(arr>='A' && arr<='Z') {  //피연산자 바로 sb에 저장 -연산자 pop하는 시점만 계산하면 됨
				sb.append(arr);
			}else if(arr ==')'){
	
				while(st.peek()!='0') { // 괄호 구분 '0' 나올때 까지 pop
					sb.append(st.pop());
				}
				st.pop(); // 괄호 구분 '0' 날리기
					
			}else {	
				if(!st.isEmpty() && (arr=='+' || arr=='-')) { //연산자가 + 또는 -인 경우
					while(!st.isEmpty() && st.peek()!='0') { 
						sb.append(st.pop());
					}
			
				} 
				if(!st.isEmpty() && (arr=='*' || arr=='/')) { //연산자가 * 또는 /인 경우  연속으로 나올때 고려
					while(!st.isEmpty() &&st.peek()!='0' &&(st.peek()=='*' ||st.peek()=='/')) {
						sb.append(st.pop());
					}
						
				}
				st.push(arr);
			}
			
		}
		
		//남은것 전부 pop
		while (!st.isEmpty()) {
			sb.append(st.pop());
		}
		
		
		System.out.println(sb);
	}

}
