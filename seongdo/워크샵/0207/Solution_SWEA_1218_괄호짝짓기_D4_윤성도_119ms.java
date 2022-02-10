package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution_SWEA_1218_괄호짝짓기_D4_윤성도_119ms {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int TC = 1; TC <= 10; TC++) {
			bw.write("#" + TC + " ");
			br.readLine();
			int ans = 1;
			String input = br.readLine();
			Stack<Character> st = new Stack<Character>();
			for(char i : input.toCharArray()) {
				switch(i) {
				case '(':
				case '{':
				case '[':
				case '<':
					st.push(i);
					break;
				case ')':
				case '}':
				case ']':
				case '>':
					if(st.empty() || (st.peek() != i-1 && st.peek() != i-2)) ans = 0;
					else st.pop();
				}
				if(ans == 0) break;
			}
			bw.write(ans + "\n");
		}
		bw.close();
	}
}
