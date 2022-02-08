import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_1406_에디터_S3_이재순_512ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//커서왼쪽 : left스택, 커서오른쪽 : right스택
		Stack<Character> left = new Stack<Character>();
		Stack<Character> right = new Stack<Character>();
		String str = br.readLine();
		int size = str.length();
		for (int i = 0; i < size; i++) {
			left.push(str.charAt(i));
		}
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			switch ((str = br.readLine()).charAt(0)) {
			case 'L':
				if (!left.empty()) {
					right.push(left.pop());
				}
				break;
			case 'D':
				if (!right.empty()) {
					left.push(right.pop());
				}
				break;
			case 'B':
				if (!left.empty()) {
					left.pop();
				}
				break;
			case 'P':
				left.push(str.charAt(2));
				break;
			}
		}
		//신기하게 스택의 밑에서부터 나옴
		for (char character : left) {
			sb.append(character);
		}
		//right는 저장해서 reverse
		StringBuilder sb2 = new StringBuilder();
		for (char character : right) {
			sb2.append(character);
		}
		System.out.println(sb.append(sb2.reverse()));
	}//end of main
}//end of class
