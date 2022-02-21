package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1592_영식이와친구들_B2_양소정_80ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int []arr = new int[N];
		int idx=0;
		int bcnt =0;
		while (true) {
			arr[idx] ++;
			if(arr[idx]==M)	break;
			bcnt++;
			if(arr[idx]%2==0) {
				for (int i = 0; i <L; i++) {
					idx--;
					if(idx==-1) idx=N-1;
				}
			}else {
				for (int i = 0; i <L; i++) {
					idx++;
					if(idx==N) idx=0;
				}
			}
		
			
		}
		System.out.println(bcnt);
	}
}
/**
idx 1부터 시작이라고 가정하고
시계방향이면서 배열 벗어날 때 idx %= N
반시계방향이면서 배열 벗어날 때 idx +=N;
*/
