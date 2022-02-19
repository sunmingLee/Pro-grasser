package pcs;

import java.util.Scanner;

public class CombinationNPTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int R = sc.nextInt();
		
		 int[] input = new int[N];
		
		for(int i=0;i<N;i++) {
			input[i] = sc.nextInt();
		}
		
		int[] p = new int[N];
		// p배열에 0보다 큰 값으로 R개를 맨 뒤부터 채움
		// 4C2 0011
		
		int cnt = 0;
		while(++cnt<=R) p[N-cnt]=1; 
		
		do {
			for(int i=0;i<N;i++) {
				if(p[i] == 1) // 정석대로 할려면 p[i] == 1, 사전순으로 출력 원할 시 p[i] == 0
					System.out.print(input[i] + " ");
			}
			System.out.println();
		}while(np(p));
	}
	
	private static boolean np(int[] p) {
		int N = p.length;
		// 1. 교환 위치 찾기 : 맨 뒤부터 탐색
		int i = N-1;
		while(i>0 && p[i-1] >= p[i]) --i;
		
		if(i==0) return false;
		
		// 2. 교한 위치에 교환할 값 찾기
		int j = N-1;
		while(p[i-1] >= p[j]) --j;
		
		// 3. 교환 위치와 교환할 값 교환하기
		swap(p, i-1, j);
		
		// 4. 교환 위치 뒤(꼭대기)부터 맨 뒤까지 만들 수 있는 가장 작은 순열 생성(오름차순 정렬)
		int k = N-1;
		while(i<k) {
			swap(p, i++, k--);
		}
		return true;
	}
	
	private static void swap(int[] p, int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}
}
