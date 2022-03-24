package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_9935_문자열폭발_G4_윤성도_320ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String exp = br.readLine();
		StringBuilder sb = new StringBuilder();
		int len = exp.length();
		for (int i = 0, size = input.length(); i < size; i++) {
			sb.append(input.charAt(i));
			if (sb.length() >= len)
				if (sb.substring(sb.length() - len).equals(exp))
					sb.delete(sb.length() - len, sb.length());
		}
		if (sb.length() == 0)
			System.out.println("FRULA");
		else
			System.out.println(sb.toString());
	}
}