package IM;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_2851_슈퍼마리오_B1_양소정_80ms{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a=0;
		int sum =0;
		for (int i = 0; i <10; i++) {
			a = Integer.parseInt(br.readLine());
			if(sum < 100) { //100보다 작다면
				sum += a;  //값 더하기
				if(sum >= 100) { //더한 값이 100보다 크거나 같다면
					if(Math.abs(100-sum) > Math.abs(100-(sum-a))) { //비교해서 더한값이 차이가 더크면 더하기 전 값 출력
						System.out.println(sum-a);
						return;					
					}else { //같거나 적으면 더한값 출력
						System.out.println(sum);
						return;
					}
				}
			}
		}
		System.out.println(sum);  //다 더했는데 100을 넘지 못하면 그냥 도합 출력
	}

}
