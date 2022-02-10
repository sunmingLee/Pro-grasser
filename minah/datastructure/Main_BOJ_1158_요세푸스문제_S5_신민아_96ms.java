package datastructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 뭔가 원형 큐를 의도한 문제 같지만 나도 모르게 그렇게 푼걸지도?
public class Main_BOJ_1158_요세푸스문제_S5_신민아_96ms {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int size = Integer.parseInt(st.nextToken()); // 초기 데이터의 개수
		int removeIndex = Integer.parseInt(st.nextToken()); // 현재 위치로부터 n번째 데이터 삭-제
		
		List<Integer> numList = new ArrayList<Integer>(size); // 1부터 size까지 가지고 있는 배열, arrayList가 remove 연산이 간편하여 사용
		for(int i=0;i<size;i++) {
			numList.add(i+1);
		}
		
		int cur = 0; // 현재 위치
		sb.append("<"); // 형식 맞춰주기
		
		while(numList.size() > 0) { // 모든 요소가 빠져 나갈때까지 반복
			int realIndex = -1 + removeIndex %  numList.size(); // size가 작아졌을 때를 대비하여 실제로 옮길 인덱스 구하기
			if(realIndex == -1) { // 예외 : 만약 (이동 수 % 실제 리스트 사이즈 == 0) 이라면 움직이지 않는 것이 아니라 한바퀴를 돌리기 한 걸음 전까지 가므로
				realIndex += numList.size(); // 값 보정
			}
			
			cur += realIndex; // 현재 위치 맞추기
			if(cur >= numList.size()) { // 현재 위치가 만약 배열의 사이즈를 넘어섰다면
				cur %= numList.size(); // 이동하고 남은 만큼 0부터 움직여야 하므로 위치 보정
			}
			
			sb.append(numList.remove(cur)).append(", "); // 출력
		}
		
		sb.setLength(sb.length() - 2); // 마지막의 ", " 제거
		sb.append(">");
		
		System.out.print(sb.toString());

	}

}
