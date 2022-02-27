package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JOL_1037_오류교정_양소정_200ms {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int []rcnt=new int[N];
		int []ccnt=new int[N];
		int [][]map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
				rcnt[i] += map[i][j]; //각 행의 합
				ccnt[j] += map[i][j]; //각 열의 합
			}
			
		}
		int idxc=0; //홀수개인 열의 idx
		int idxr=0; //홀수개인 행의 idx
		int tcnt=0; //안맞는 행과 열의 합이 2개 이하여야 chage bit
		boolean flag = true;
		for (int i = 0; i < N; i++) {
			if(rcnt[i]%2 != 0 ) {
				
				flag = false;
				idxr = i;
				tcnt++;
			}
		}
			
		for (int i = 0; i < N; i++) {
			if(ccnt[i]%2 != 0 ) {
				
				flag = false;
				idxc = i;
				tcnt++;
			}
		}
	
		if(flag) {
			System.out.println("OK");
		}else if(rcnt[idxr]%2!=0 &&ccnt[idxc]%2!=0 &&tcnt<=2){
			System.out.print("Change bit ("+(idxr+1)+","+(idxc+1)+")");
		}else {
			System.out.println("Corrupt");
		}

	}
}
