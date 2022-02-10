package datastructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_1874_스택수열_S3_신민아_344ms {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> numStack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		
		int maxNum = Integer.parseInt(br.readLine()); // 최대로 받을 수 있는 숫자
		int count = 1; // 숫자를 몇까지 push했는지 카운트
		
		while(true) {
			int nextNum = Integer.parseInt(br.readLine()); // 다음에 꺼내야 할 숫자
			
			if(numStack.isEmpty() || numStack.peek() < nextNum) { // 스택이 비어있거나 마지막에 넣은 요소가 다음 숫자보다 작다면
				for(int j=count;j<=nextNum;j++) { // 그만큼 넣어주기
					numStack.push(j);
					sb.append("+").append("\n");
					count++; // 몇까지 넣었는지 카운트
				}
			} else if(numStack.peek() > nextNum) { // 마지막 요소가 다음 숫자보다 크다면 꺼낼 수 없는 상황
				sb = new StringBuilder();
				sb.append("NO"); // 스트링빌더 초기화 후 NO만 붙이고 종료
				break;
			}
			
			if(!numStack.isEmpty() && numStack.peek() == nextNum) { // 스택이 비지 않고 마지막 요소가 다음 숫자랑 같다면
				numStack.pop(); // 꺼내기
				sb.append("-").append("\n");
			}
			
			if(numStack.isEmpty() && count == maxNum+1) { // 탈출 조건 : 스택이 비었고 모든 카운트 소진 시
				break;
			}
			
		}
		
		System.out.print(sb.toString());

	}

}
