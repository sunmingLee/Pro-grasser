package datastructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 두가지로 풀 수 있을 듯 : String을 담는 arraylist에 cursor값을 두어 이동하면서 삭제, 삽입연산하거나
 * 현재 나온 것처럼 2개의 스택(temp, original)을 사용하거나!!
 * 
 */
public class Main_BOJ_1406_에디터_S3_신민아_504ms {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		String originalContent = br.readLine(); // 원래의 콘텐츠
		int opCount = Integer.parseInt(br.readLine()); // 연산을 하는 총 개수
		
		Stack<Character> original = new Stack<Character>(); // 원래의 문자열이 들어있는 스택
		Stack<Character> temp = new Stack<Character>(); // 연산 중 커서 조작을 위한 임시용 스택 -> 모든 연산 종료 후 original stack에 옮겨야 함
		
		for(int i=0;i<originalContent.length();i++) { // 원래의 stack에 하나씩 데이터를 집어넣음
			original.push(originalContent.charAt(i));
		}
		
		for(int count=0;count<opCount;count++) { // 연산 수 만큼 반복
			String command = br.readLine(); // 연산 읽기
			switch(command.charAt(0)) { // 어떤 종류의 연산인지 확인
				case 'L': // 커서를 좌측으로 이동
					if(!original.isEmpty()) { // 오리지널이 비어있지 않다면 temp 스택으로 옮김
						temp.push(original.pop());
					}
					break;
					
				case 'D': // 커서를 우측으로 이동
					if(!temp.isEmpty()) { // temp 스택이 비어있지 않다면 오리지널로 이동
						original.push(temp.pop());
					}
					break;
					
				case 'P': // 무조건 새로운 글자를 push
					original.push(command.charAt(2));
					break;
					
				case 'B': // 글자 삭제
					if(!original.isEmpty()) { // 오리지널에 데이터가 남았다면 삭제
						original.pop();
					}
					
			}
		}
		
		while(!temp.isEmpty()) { // temp 스택에 남은 데이터 original로 flush
			original.push(temp.pop());
		}
		
		for(int i=0;i<original.size();i++) { // 출력
			sb.append(original.get(i));
		}
		
		System.out.print(sb.toString());

	}

}
