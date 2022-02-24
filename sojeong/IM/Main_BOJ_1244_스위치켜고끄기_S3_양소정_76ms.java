package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1244_스위치켜고끄기_S3_양소정_76ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int []arr = new int[N+1];
		
		st= new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); //성별
			int b = Integer.parseInt(st.nextToken()); //받은 숫자
		switch (a) {
		case 1:
			for (int j = 1; j <= N; j++) {
				if(j%b==0) {
					arr[j] ^= 1; //xor 두 비트가 모두 같으면 0 다르면 1
								// 1과 xor하면 만약 둘다 1 일땐 같으니 0 , 0일땐 다르니 1을 반환해 반대 값이 됨 
				}
			}
			break;
		case 2:
			for (int j = 1; j <= N/2; j++) {
				if(b-j>0 && b+j<=N && arr[b-j]==arr[b+j]) {
					continue;
				}else {
					for (int k = b-j+1 ; k <=b+j-1; k++) {
						arr[k] ^= 1; //xor
					}
					break;
				}
			}
			break;
		}	
			
		}
		for (int i = 1; i <= N; i++) {
			System.out.print(arr[i]+" ");
			if(i%20==0) System.out.println();
		}
		
	}

}
