package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_SWEA_1208_Flatten_D3_이재순_131ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		PriorityQueue<Integer> pQueueMin;
		PriorityQueue<Integer> pQueueMax;
loop:	for (int testcase = 1; testcase < 11; testcase++) {
			int N = Integer.parseInt(br.readLine());
			pQueueMin = new PriorityQueue<Integer>();
			pQueueMax = new PriorityQueue<Integer>(Collections.reverseOrder());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				int temp =Integer.parseInt(st.nextToken());
				pQueueMax.offer(temp);
				pQueueMin.offer(temp);
			}
			for (int i = 0; i < N; i++) {
				pQueueMax.offer(pQueueMax.poll()-1);
				pQueueMin.offer(pQueueMin.poll()+1);
				if (pQueueMax.peek()==pQueueMin.peek()) {
					sb.append("#").append(testcase).append(" ").append(0).append("\n");
					continue loop;
					
				}
				else if (pQueueMax.peek()<pQueueMin.peek()) {
					sb.append("#").append(testcase).append(" ").append(1).append("\n");
					continue loop;
				}
			}
			sb.append("#").append(testcase).append(" ").append(pQueueMax.poll()-pQueueMin.poll()).append("\n");
		}
		System.out.print(sb);
	}
}
