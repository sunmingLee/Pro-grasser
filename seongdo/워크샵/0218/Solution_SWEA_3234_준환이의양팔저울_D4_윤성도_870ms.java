package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_3234_준환이의양팔저울_D4_윤성도_870ms {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 값을 받기 위해 BufferedReader 사용
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
		StringBuilder sb = new StringBuilder(); // 출력할 내용 저장
		
		for(int TC = 1; TC <= T; TC++) { // 테스트 케이스 개수만큼 반복
			int N = Integer.parseInt(br.readLine()); // 무게 추의 개수
			int[] wt = new int[N]; // 무게 추의 무게를 저장할 배열
			StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 입력 값을 띄어쓰기 단위로 구분 
			for(int i = 0; i < N; i++) wt[i] = Integer.parseInt(st.nextToken()); // 무게 추의 무게를 저장
			
			Arrays.sort(wt); // Next Permutation을 이용하여 순열을 구하기 위해 오름차순 정렬
			int ans = 0; // 가능한 경우의 수를 저장할 변수
			do { // 정렬이 된 상태가 첫번째 순열이기 때문에 do-while문 사용
				int left = wt[0];	// 왼쪽 저울 무게의 합	|right < left가 되어야 하기 때문에 
				int right = 0;		// 오른쪽 저울 무게의 합	|첫번째 무게추는 항상 왼쪽에 두고 시작
				ans += subset(wt, left, right, 1, N); // 가능한 모든 경우를 추가, 첫번째 무게추를 왼쪽에 이미 추가하여 1부터 시작
			}while(nextPermutation(wt)); // 다음 순열이 없을 때까지 반복
			sb.append("#").append(TC).append(" ").append(ans).append("\n"); // 출력 형식에 맞춰 저장
		} // end of TestCase
		System.out.println(sb.toString()); // 모든 테스트케이스를 완료한 후 저장한 데이터를 출력
	} // end of main
	
	private static boolean nextPermutation(int[] list) { // nextPermutation 구현
		int i = list.length - 1; // i와 j를 모두 
		int j = list.length - 1; // 마지막 원소로 설정
		while(i > 0 && list[i-1] >= list[i]) --i; // i-1번째 원소가 i보다 작아지는 지점을 탐색
		if(i <= 0) return false; // 내림차순으로 되어있으면 다음 순열이 없으므로 false 반환
		while(list[i-1] >= list[j]) --j; // i-1번째 원소보다 j번째 원소가 커지는 지점을 탐색 (i-1번째보다 i번째가 항상 크기때문에 가능한 j가 무조건 존재)
		swap(list, i-1, j); // i-1번째 원소와 j번째 원소의 위치를 바꿈
		j = list.length - 1; // j가 다시 마지막 원소를 가리킴
		for(; i < j; ++i, --j) swap(list, i, j); // 내림차순으로 되어있는 i번째 이후를 오름차순으로 바꾸어 줌
		return true; // list가 다음 순열의 순서로 바뀌었기 때문에 true 반환
	} // end of nextPermutation
	
	private static void swap(int[] list, int a, int b) { // swap 구현
		int tmp = list[a];	// a번째 위치한 원소와
		list[a] = list[b];	// b번째 위치한 원소의
		list[b] = tmp;		// 위치를 바꿈
	} // end of swap
	
	private static int subset(int[] list, int left, int right, int index, int N) { // index번째 무게 추를 어느쪽에 올릴 지 부분집합으로 구현
		if(left < right) return 0; // right의 무게가 left의 무게보다 큰 순간 조건에 위배되기 때문에 0 반환 
		if(index == N) return 1; // 모든 무게추를 올리는데 성공하면 1 반환
		// 아직 올릴 무게 추가 남아 있을 땐 왼쪽에 올렸을 때의 경우의 수와 오른쪽에 올렸을 때의 경우의 수를 더해서 반환
		return subset(list, left + list[index], right, index + 1, N) + subset(list, left, right + list[index], index + 1, N);
	} // end of subset
} // end of class
