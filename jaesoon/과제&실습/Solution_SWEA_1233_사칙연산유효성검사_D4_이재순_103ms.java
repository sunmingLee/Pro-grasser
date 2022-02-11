package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1233_사칙연산유효성검사_D4_이재순_103ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
loop:	for (int testcase = 1; testcase < 11; testcase++) {
			int N = Integer.parseInt(br.readLine())+1;
			int N2 = N/2;
			for (int i = 1; i <N2; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				switch (st.nextToken()) {
				case "+": case "-": case "*": case "/":
					break;
				default:
					sb.append("#").append(testcase).append(" 0\n");
					for (int j = i+1; j <N; j++) {
						br.readLine();
					}
					continue loop;
				}
			}
			for (int i = N2; i <N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				switch (st.nextToken()) {
				case "+": 	case "-": case "*": case "/":
					sb.append("#").append(testcase).append(" 0\n");
					for (int j = i+1; j <N; j++) {
						br.readLine();
					}
					continue loop;
				default:
					break;
				}
			}
			sb.append("#").append(testcase).append(" 1\n");
		}
		System.out.print(sb);
	}//end of main
}//end of class
