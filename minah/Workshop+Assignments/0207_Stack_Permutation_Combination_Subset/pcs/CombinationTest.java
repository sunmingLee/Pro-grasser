package pcs;

import java.util.Arrays;
import java.util.Scanner;

public class CombinationTest {
	// 입력된 값을 저장하는 변수
	static int N, R;
	// input : 입력 받은 수의 배열, numbers : 선택된 수의 배열
	static int[] input, numbers;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[N];
		numbers = new int[R];
		
		for(int i=0;i<N;i++) {
			input[i] = sc.nextInt();
		}
		
		combination(0, 0);

	}
	
	public static void combination(int cnt, int start) {
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=start;i<N;i++) {
			numbers[cnt] = input[i];
			combination(cnt+1, i+1); // 다음 자리는 현재 뽑은 i의 다음 수부터 시작하도록 전달
		}
	}

}
