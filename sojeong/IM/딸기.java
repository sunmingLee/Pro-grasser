package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 딸기 {
	private static int N;
	private static int sum1,sum2,sum3;
	private static int[][] map;
	private static int str;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			int total=0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					total+=map[i][j];
				}
			}
			str = total/4; //한 구역당 목표하는 딸기 수 
			
			if(total%4 != 0 ) { //총 딸기가 4등분 안되면
				sb.append("0");
				continue;
				
			}
			
			
here:		for (int i = 0; i <N-1; i++) {
				for (int j = 0; j <N-1; j++) {
					go(i,j);
					if( sum2!=0 &sum3!=0 && sum1+sum2+sum3 == str*3) { //뒤에 안합치고 리턴한 값이 str3일수도 있으니 0이 아닐때 추가
						sb.append("1").append("\n");
						break here;  //가능한거 찾으면 더이상 찾을 필요 x
					}
				}
			}
			if ( sum2!=0 &&sum3!=0 && sum1+sum2+sum3 !=str*3) {  
				sb.append(" ").append("\n");
			
			}
			
		}//end of tc
		System.out.println(sb);
		
	}

	private static void go(int x, int y) {
		sum1=0;
		sum2=0;
		sum3=0;
		
		//1사분면
	for (int i = 0; i <= x; i++) {
			for (int j = 0; j <= y; j++) {
				sum1 += map[i][j];
				if(sum1 > str) { //4등분 해야되는 딸기 수 보다 크면
		
					return;
				}
			}
		}
		if(sum1!=str) return; //목표 딸기 수 보다 작은경우
		
		//2사분면
		for (int i = 0; i <= x; i++) {
			for (int j = y+1; j <N; j++) {
				sum2 += map[i][j];
				if(sum2 > str) {
			
					return;
				}
				
			}
		}
		if(sum2!=str)  return;
	
		
		//3사분면
		for (int i = x+1; i < N ; i++) {
			for (int j = 0; j <= y; j++) {
				sum3 += map[i][j];
				if(sum3 > str) {
					sb.append("0");
					return;
				}
				
			}
		}
		if(sum3!=str) 	return;
	
	}

}
