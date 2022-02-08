package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_1874_스택수열_S3_윤성도_376ms {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> st = new Stack<>();
		int index = 1;
		
		for(int i = 0; i < n; i++) {
			int number = Integer.parseInt(br.readLine());
			while(st.empty() || st.peek() < number) {
				st.push(index++);
				sb.append("+\n");
			}
			if(st.peek() == number) {
				st.pop();
				sb.append("-\n");				
			}else {
				System.out.println("NO");
				return;
			}
		}
		System.out.println(sb.toString());
	}
}