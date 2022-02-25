package IM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_10158_개미_S4_양소정_80ms  {
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int q = Integer.parseInt(st.nextToken()); //q가 x
		int p = Integer.parseInt(st.nextToken()); //p가 y
		int t = Integer.parseInt(br.readLine());
	
		int x = (q+t)%(2*W);  // 현재위치에서 시간만큼 간 위치 는 w*2를 순환
		int y = (p+t)%(2*H);
		
		// 나머지의 값이 W보다 작을 때는 그냥 나머지이고 W보다 크다면 2W - 나머지를 해야함
		x = W - Math.abs(W-x); // W - abs( W - mod( P+T , 2W) )
		y = H - Math.abs(H-y); // H - abs( H - mod( q+T , 2H) ) 
		
		System.out.println(x+" "+y);
	}

}
