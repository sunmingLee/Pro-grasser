package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_6550_부분문자열_S5_윤성도_200ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = "";
		
		while((input = br.readLine())!=null) {
			StringTokenizer st = new StringTokenizer(input);
			String s = st.nextToken();
			String t = st.nextToken();
			int index = 0;
			
			for(int i = 0; index < s.length() && i < t.length(); i++) {
				if(t.charAt(i) == s.charAt(index)) {
					index++;
				}
			}
			if(index == s.length()) {
				sb.append("Yes\n");
			}else {
				sb.append("No\n");
			}
		}
		System.out.println(sb.toString());
	}
}
