import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1233_사칙연산유효성검사_D4_이선민_118ms {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("C:\\SSAFY\\01_java\\0210\\src\\input (2).txt"));
		StringBuilder sb = new StringBuilder(40); // 출력해야할 내용을 안다면 크기를 대강 정해주는것이 좋음
		StringTokenizer st;
		int N, isOkay, h, cnt;
		char temp;
		for (int test_case = 1; test_case <= 10; test_case++) {
			N = Integer.parseInt(br.readLine()); // 트리의 총 노드 개수(1≤N≤200)
			isOkay = 1; // 식의 유효성(유효함 : 1, 유효하지 않음 : 0)
//			식이 유효하지 않은 경우 : 해당 노드가 연산자인데 자식이 2개가 아닌 경우

			h = 0; // 트리의 높이
			while (Math.pow(2, h) <= N) {
				h++;
			}
			h--;

			cnt = 0;
			outer: while (cnt < N) {
				cnt++;
				st = new StringTokenizer(br.readLine());
				st.nextToken(); // 현재 노드 번호 (필요 x)
				temp = st.nextToken().charAt(0); // 현재노드의 내용
				if (isOkay == 0) { // 유효하지 않은 트리인걸 알았어도 다음 테스트케이스까지 문자열을 읽어와야함.
					continue;
				}
				// (높이-2)까지는 노드가 연산자인지만 확인
				if (cnt < Math.pow(2, h - 1)) {
					switch (temp) {
					case '+':
					case '-':
					case '*':
					case '/':
						continue outer;
					}
					isOkay = 0;
					continue;
				}

				// 높이-1은 자식의 유무도 확인
				if (cnt < Math.pow(2, h)) {
					switch (temp) {
					case '+':
					case '-':
					case '*':
					case '/':
						if (cnt * 2 + 1 > N) { // 오른쪽 자식노드의 번호(i*2+1)가 테스트케이스의 노드개수보다 크다면 자식노드가 2개 미만임
							isOkay = 0;
							continue outer;
						}
						break;
					default: // 해당 노드가 숫자라면 자식이 없어야함
						if (cnt * 2 < N) {
							isOkay = 0;
							continue outer;
						}
						break;
					}
					continue;
				}

				// 마지막 레벨은 숫자인지만 확인
				switch (temp) {
				case '+':
				case '-':
				case '*':
				case '/':
					isOkay = 0;
					break;
				}

			} // end of outer

			sb.append("#").append(test_case).append(" ").append(isOkay).append("\n");
		} // end of testcase

		System.out.print(sb);
	} // end of main

} // end of class
