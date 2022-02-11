package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_SWEA_1218_괄호짝짓기_D4_이재순_101ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> st = new Stack<Character>();
		loop:
		for (int i = 1; i < 11; i++) {
			sb.append("#").append(i).append(" ");
			int size = Integer.parseInt(br.readLine());
			String str = br.readLine();
			for (int j = 0; j < size; j++) {
				switch (str.charAt(j)) {
				case '{':
				case '[':
				case '(':
				case '<':
					st.push(str.charAt(j));
					break;
				case ')':
					if (!st.isEmpty()&&st.pop()=='(') break;
					else { 
						sb.append("0\n");
						continue loop;
					}
				case '}':
					if (!st.isEmpty()&&st.pop()=='{') break;
					else { 
						sb.append("0\n");
						continue loop;
					}
				case ']':
					if (!st.isEmpty()&&st.pop()=='[') break;
					else { 
						sb.append("0\n");
						continue loop;
					}
				case '>':
					if (!st.isEmpty()&&st.pop()=='[') break;
					else { 
						sb.append("0\n");
						continue loop;
					}
				}
			}
			sb.append("1\n");
		}
		System.out.println(sb);
	}
}
