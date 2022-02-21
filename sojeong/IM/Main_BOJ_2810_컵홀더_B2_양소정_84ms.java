package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_2810_컵홀더_B2_양소정_84ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		int cnt = N+1; //총 컵홀더 수 
		String str = null;
		str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'L') {
				cnt--; //커플석이면 둘 수 있는 컵홀더 감소
				i++; //다음도 L이므로 한칸 넘기기
			}
		}
		if(cnt >N) System.out.println(N); 
		else System.out.println(cnt);
	}
	
}
