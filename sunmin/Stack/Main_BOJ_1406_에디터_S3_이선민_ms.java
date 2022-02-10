package Stack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 한 줄로 된 간단한 에디터를 구현하려고 한다. 이 편집기는 영어 소문자만을 기록할 수 있는 편집기로, 최대 600,000글자까지 입력할 수
 * 있다.
 * 
 * 이 편집기에는 '커서'라는 것이 있는데, 커서는 문장의 맨 앞(첫 번째 문자의 왼쪽), 문장의 맨 뒤(마지막 문자의 오른쪽), 또는 문장
 * 중간 임의의 곳(모든 연속된 두 문자 사이)에 위치할 수 있다. 즉 길이가 L인 문자열이 현재 편집기에 입력되어 있으면, 커서가 위치할 수
 * 있는 곳은 L+1가지 경우가 있다.
 * 
 * 이 편집기가 지원하는 명령어는 다음과 같다.
 * 
 * L : 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨) D : 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면
 * 무시됨) B : 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨) 삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼
 * 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임 P $ : $라는 문자를 커서 왼쪽에 추가함
 * 
 * 초기에 편집기에 입력되어 있는 문자열이 주어지고, 그 이후 입력한 명령어가 차례로 주어졌을 때, 모든 명령어를 수행하고 난 후 편집기에
 * 입력되어 있는 문자열을 구하는 프로그램을 작성하시오. 단, 명령어가 수행되기 전에 커서는 문장의 맨 뒤에 위치하고 있다고 한다.
 *
 */
public class Main_BOJ_1406_에디터_S3_이선민_ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		long start = System.currentTimeMillis();
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("C:\\SSAFY\\01_java\\BOJ\\src\\Stack\\input.txt"));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		String s = br.readLine(); // 초기 문자열
		int cursor = s.length(); // 현재 커서의 위치(문장의 맨 뒤)

		// LinkedList에 초기 문자열을 담아줌
		List<Character> list = new LinkedList<Character>();
		for (int i = 0; i < s.length(); i++) {
			list.add(s.charAt(i));
		}

		int M = Integer.parseInt(br.readLine()); // 명령어의 개수
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "L":
				if (cursor == 0) { // 커서가 문장의 맨 앞이면 명령을 무시함
					break;
				}
				cursor--;
				break;
			case "D":
				if (cursor == list.size()) { // 커서가 문장의 맨 뒤이면 명령을 무시함
					break;
				}
				cursor++;
				break;
			case "B":
				if (cursor == 0) { // 커서가 문장의 맨 앞이면 명령을 무시함
					break;
				}
				list.remove(--cursor);
				break;
			case "P":
				char $ = st.nextToken().charAt(0); // 새로 추가할 문자
				list.add(cursor++, $);
				break;

			default:
				System.out.println("wrong command");
				break;
			} // end of switch
			System.out.println(list);
		} // end of for loop
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
		}
		sb.append("\n");
		System.out.print(sb);
		
		long end = System.currentTimeMillis();
		System.out.println("수행시간: " + (end - start) + " ms");
	} // end of main

} // end of class
