package march0310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/*
반례 A*B+C+D+E*F*G+E 
답 AB*C+D+EF*G*+E+   

조심할 것 , ***(///)연속으로 나오는 경우 
while문 돌릴때 EmptyStack 먼저 검사
*/
public class Main_BOJ_1918_후위표기식_G3_양소정_88ms{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine(); //입력
		StringBuilder sb = new StringBuilder();
		Stack<Character> st = new Stack<Character>();
		int f=0;
	
		char arr[] = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
			if(arr[i] =='(') {
				st.push('0');
				continue;
			}
			if(arr[i]>='A' && arr[i]<='Z') {
				sb.append(arr[i]);
			}else if(arr[i] ==')'){
	
				while(st.peek()!='0') {
					sb.append(st.pop());
				}
				st.pop();
					
			}else {	
				if(!st.isEmpty() && (arr[i]=='+' || arr[i]=='-')) {
					while(!st.isEmpty() && st.peek()!='0') {
						sb.append(st.pop());
					}
			
				}
				if(!st.isEmpty() && (arr[i]=='*' || arr[i]=='/')) {
					while(!st.isEmpty() &&st.peek()!='0' &&(st.peek()=='*' ||st.peek()=='/')) {
						sb.append(st.pop());
					}
						
				}
				st.push(arr[i]);
			}
			
		}
		while (!st.isEmpty()) {
			sb.append(st.pop());
		}
		
		
		System.out.println(sb);
	}

}
