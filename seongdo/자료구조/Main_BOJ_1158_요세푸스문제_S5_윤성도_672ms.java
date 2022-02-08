package com.ssafy.BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BOJ_1158_요세푸스문제_S5_윤성도_672ms {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int K = sc.nextInt();
		int index = 1;
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		sb.append("<");
		while(true) {
			if(index++ == K) {
				sb.append(q.poll());
				if(q.isEmpty()) {
					sb.append(">");
					break;
				}
				sb.append(", ");
				index = 1;
			}else {
				q.offer(q.poll());
			}
		}
		System.out.println(sb.toString());
	}
}
