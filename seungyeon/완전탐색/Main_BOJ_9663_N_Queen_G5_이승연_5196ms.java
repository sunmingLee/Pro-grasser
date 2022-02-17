package algo_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_9663_N_Queen_G5_이승연_5196ms {
	private static int N;
	private static int[] arr;
	private static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // (1 ≤ N < 15)
		arr = new int[N]; // index: r, 해당 index의 값: c
		result = 0;
		
		calcQueens(0);
		
		System.out.println(result);
	}
	
	public static void calcQueens(int r) {
		if(r == N) {
			result++;
			return;
		}
		
		for(int c=0; c<N; c++) {
			arr[r] = c;
			if(isAvailable(r)) {
				calcQueens(r+1);
			}
		}
//		for(int c=0; c<N; c++) {
//			arr[r] = c;
//			boolean flag = true;
//			
//			for(int i=0; i<r; i++) {
//				if(arr[i] == c || r-i == Math.abs(c-arr[i])) { // 열이 같은게 있으면 안됨. 행의 차 = 열의 차 -> 대각선에 존재
//					flag = false; 
//				}
//			}
//			
//			if(flag) { // c가 열이 될 수 있음. 
//				calcQueens(r+1); // 다음 행에 열 정하러감.
//			}
//		}
	}
	
	public static boolean isAvailable(int r) {
		for(int i=0; i<r; i++) {
			if(arr[r] == arr[i] || r-i == Math.abs(arr[r] -arr[i])) return false; 
		}
		
		return true;
	}
}
