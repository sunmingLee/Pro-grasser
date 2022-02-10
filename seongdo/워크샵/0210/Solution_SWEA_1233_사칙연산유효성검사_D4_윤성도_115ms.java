package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_1233_사칙연산유효성검사_D4_윤성도_115ms {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String num = "0123456789"; // 숫자 판별을 위한 변수
		
		for(int i = 0; i < 10; i++) {
			int N = Integer.parseInt(br.readLine()); // 노드의 갯수 입력
			int valid = 1; // 유효성 판별을 위한 변수
			for(int j = 0; j < N; j++) {
				String input = br.readLine();
				if(valid == 1) { // 이미 유효하지 않을 경우는 검사하지 않고 입력값만 넘김
					String[] data = input.split(" ");
					switch(data.length) { // 입력 값의 갯수로 자식노드 갯수 판단
					case 2: // 자식노드가 없을 때 == 말단노드일 때
						if(!num.contains(data[1])) valid = 0; // 숫자가 아니면 유효하지 않음
						break;
					case 3: // 자식노드가 1개일 때
						valid = 0; // 유효하지 않음
						break;
					case 4: // 자식노드가 2개일 때
						if(num.contains(data[1])) valid = 0; // 숫자이면 유효하지 않음
					}
				}
			}
			sb.append("#").append(i+1).append(" ").append(valid).append("\n");
		}
		System.out.println(sb.toString());
	}
}
