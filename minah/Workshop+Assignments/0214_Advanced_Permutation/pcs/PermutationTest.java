package pcs;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationTest {
	// 입력된 값을 저장하는 변수
	static int N, R;
	// input : 입력 받은 수의 배열, numbers : 선택된 수의 배열
	static int[] input, numbers;
	
	// nPr
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[N];
		numbers = new int[R];
		
		
		for(int i=0;i<N;i++) {
			input[i] = sc.nextInt();
		}
			
		permutation(0,0);

	}
	
	// 현재 자리(cnt)에 수 뽑기
	public static void permutation(int cnt, int flag) { // cnt : 직전까지 뽑은 수의 개수, flag : 뽑힌 수들에 대한 플래그비트열
		// 기본 파트
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		// 입력 받은 모든 수를 현재 자리에 넣어 보기
		for(int i=0;i<N;i++) {
			// 기존 자리의 수들과 중복되는지 체크
			if((flag & 1<<i) != 0) continue;
			
			numbers[cnt] = input[i];
			
			// 다음 수 뽑으러 가기
			permutation(cnt+1, flag | 1<<i);
		}
	}

}
